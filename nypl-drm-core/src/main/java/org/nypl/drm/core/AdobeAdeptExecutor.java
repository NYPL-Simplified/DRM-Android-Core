package org.nypl.drm.core;

import android.os.Process;
import com.io7m.jnull.NullCheck;
import com.io7m.junreachable.UnreachableCodeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * The default implementation of the {@link AdobeAdeptExecutorType}. The
 * executor instantiates a new instance of the {@link AdobeAdeptConnectorType}
 * interface from the given {@link AdobeAdeptConnectorFactoryType}, and runs all
 * submitted {@link AdobeAdeptProcedureType} values on a single dedicated
 * background thread.
 */

public final class AdobeAdeptExecutor implements AdobeAdeptExecutorType
{
  private static final Logger LOG;

  static {
    LOG = NullCheck.notNull(LoggerFactory.getLogger(AdobeAdeptExecutor.class));
  }

  private final ExecutorService         exec;
  private final AdobeAdeptConnectorType connector;

  private AdobeAdeptExecutor(
    final ExecutorService in_exec,
    final AdobeAdeptConnectorType in_connector)
  {
    this.exec = NullCheck.notNull(in_exec);
    this.connector = NullCheck.notNull(in_connector);
  }

  /**
   * Construct a new executor using the given connector factory and arguments.
   *
   * @param factory         A connector factory
   * @param package_name    The application package name
   * @param package_version The application package version
   * @param res             A resource provider
   * @param net             A net provider
   * @param device_serial   The serial number of the device
   * @param device_name     The name of the device
   * @param app_storage     The path to application storage
   * @param xml_storage     The path to XML storage
   * @param book_path       The path to fulfilled books
   * @param temporary_dir   A directory usable for temporary private file
   *                        storage (such as the per-application Android
   *                        external cache directory).
   *
   * @return A new executor
   *
   * @throws DRMException         If DRM is not supported, or there was an error
   *                              initializing the DRM
   * @throws InterruptedException If initialization of the DRM package was
   *                              interrupted
   */

  public static AdobeAdeptExecutorType newExecutor(
    final AdobeAdeptConnectorFactoryType factory,
    final String package_name,
    final String package_version,
    final AdobeAdeptResourceProviderType res,
    final AdobeAdeptNetProviderType net,
    final String device_serial,
    final String device_name,
    final File app_storage,
    final File xml_storage,
    final File book_path,
    final File temporary_dir)
    throws DRMException, InterruptedException
  {
    NullCheck.notNull(factory);
    NullCheck.notNull(package_name);
    NullCheck.notNull(package_version);
    NullCheck.notNull(res);
    NullCheck.notNull(net);
    NullCheck.notNull(device_serial);
    NullCheck.notNull(device_name);
    NullCheck.notNull(app_storage);
    NullCheck.notNull(xml_storage);
    NullCheck.notNull(book_path);
    NullCheck.notNull(temporary_dir);

    final ThreadFactory tf = Executors.defaultThreadFactory();
    final ThreadFactory named = new ThreadFactory()
    {
      @Override public Thread newThread(
        final Runnable r)
      {
        /**
         * Apparently, it's necessary to use {@link android.os.Process} to set
         * the thread priority, rather than the standard Java thread
         * functions.
         */

        final Thread t = tf.newThread(
          new Runnable()
          {
            @Override public void run()
            {
              android.os.Process.setThreadPriority(
                Process.THREAD_PRIORITY_BACKGROUND);
              NullCheck.notNull(r).run();
            }
          });
        t.setName("nypl-drm-adobe-task");
        AdobeAdeptExecutor.LOG.trace("created thread: {}", t);
        return t;
      }
    };

    final ExecutorService exec = Executors.newSingleThreadExecutor(named);
    final AdobeAdeptConnectorType connector;

    try {
      connector = exec.submit(
        new Callable<AdobeAdeptConnectorType>()
        {
          @Override public AdobeAdeptConnectorType call()
            throws Exception
          {
            return factory.get(
              package_name,
              package_version,
              res,
              net,
              device_serial,
              device_name,
              app_storage,
              xml_storage,
              book_path,
              temporary_dir);
          }
        }).get();
    } catch (final InterruptedException e) {
      exec.shutdownNow();
      throw e;
    } catch (final ExecutionException e) {
      exec.shutdownNow();
      final Throwable cause = e.getCause();
      if (cause instanceof DRMException) {
        throw (DRMException) cause;
      }

      // XXX: Not exactly true...
      throw new UnreachableCodeException();
    }

    return new AdobeAdeptExecutor(exec, connector);
  }

  @Override public void execute(final AdobeAdeptProcedureType p)
  {
    NullCheck.notNull(p);

    final AdobeAdeptConnectorType c = this.connector;
    this.exec.execute(
      new Runnable()
      {
        @Override public void run()
        {
          AdobeAdeptExecutor.LOG.trace("executing {}", p);
          p.executeWith(c);
        }
      });
  }
}
