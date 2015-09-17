package org.nypl.drm.core;

import com.io7m.jnull.NullCheck;
import com.io7m.jnull.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//@formatter:off

/**
 * <p>The default implementation of the {@link AdobeAdeptConnectorFactoryType}
 * interface.</p>
 *
 * @see AdobeAdeptConnectorFactory
 */

//@formatter:on

public final class AdobeAdeptContentFilterFactory
  implements AdobeAdeptContentFilterFactoryType
{
  private static final     String                      CLASS_NAME;
  private static final     Logger                      LOG;
  private static @Nullable AdobeAdeptContentFilterType INSTANCE;

  static {
    LOG = NullCheck.notNull(
      LoggerFactory.getLogger(AdobeAdeptContentFilterFactory.class));

    CLASS_NAME = "org.nypl.drm.adobe.AdobeAdeptContentFilter";
  }

  private AdobeAdeptContentFilterFactory()
  {
    // Nothing
  }

  /**
   * @return A new factory
   */

  public static AdobeAdeptContentFilterFactoryType get()
  {
    return new AdobeAdeptContentFilterFactory();
  }

  @Override public AdobeAdeptContentFilterType get(
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
    throws DRMException
  {
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

    try {
      if (AdobeAdeptContentFilterFactory.INSTANCE != null) {
        AdobeAdeptContentFilterFactory.LOG.debug(
          "returning saved instance {}",
          AdobeAdeptContentFilterFactory.INSTANCE);
        return NullCheck.notNull(AdobeAdeptContentFilterFactory.INSTANCE);
      }

      AdobeAdeptContentFilterFactory.LOG.debug(
        "looking up class {}", AdobeAdeptContentFilterFactory.CLASS_NAME);
      @SuppressWarnings("unchecked")
      final Class<? extends AdobeAdeptContentFilterType> c =
        (Class<? extends AdobeAdeptContentFilterType>) Class.forName(
          AdobeAdeptContentFilterFactory.CLASS_NAME);

      AdobeAdeptContentFilterFactory.LOG.debug(
        "looking up 'get' method on {}", c);
      final Method gm = c.getMethod(
        "get",
        String.class,
        String.class,
        AdobeAdeptResourceProviderType.class,
        AdobeAdeptNetProviderType.class,
        String.class,
        String.class,
        File.class,
        File.class,
        File.class,
        File.class);

      AdobeAdeptContentFilterFactory.LOG.debug(
        "invoking 'get' method on {}", c);
      final AdobeAdeptContentFilterType instance = NullCheck.notNull(
        (AdobeAdeptContentFilterType) gm.invoke(
          null,
          package_name,
          package_version,
          res,
          net,
          device_serial,
          device_name,
          app_storage,
          xml_storage,
          book_path,
          temporary_dir));

      AdobeAdeptContentFilterFactory.INSTANCE = instance;
      AdobeAdeptContentFilterFactory.LOG.debug("returning fresh instance");
      return instance;

    } catch (final ClassNotFoundException e) {
      throw new DRMUnsupportedException(e);
    } catch (final NoSuchMethodException e) {
      throw new DRMUnsupportedException(e);
    } catch (final SecurityException e) {
      throw new DRMUnsupportedException(e);
    } catch (final IllegalAccessException e) {
      throw new DRMUnsupportedException(e);
    } catch (final IllegalArgumentException e) {
      throw new DRMUnsupportedException(e);
    } catch (final InvocationTargetException e) {
      throw new DRMUnsupportedException(e);
    }
  }
}
