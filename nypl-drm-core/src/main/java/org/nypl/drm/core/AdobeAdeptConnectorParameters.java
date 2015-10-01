/*
 * Copyright © 2015 <code@io7m.com> http://io7m.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package org.nypl.drm.core;

import com.io7m.jnull.NullCheck;

import java.io.File;

/**
 * Parameters for the Adobe Adept Connector.
 *
 * @see AdobeAdeptConnectorFactoryType
 */

public final class AdobeAdeptConnectorParameters
{
  private final String                         package_name;
  private final String                         package_version;
  private final AdobeAdeptResourceProviderType res;
  private final AdobeAdeptNetProviderType      net;
  private final String                         device_serial;
  private final String                         device_name;
  private final File                           app_storage;
  private final File                           xml_storage;
  private final File                           book_path;
  private final File                           temporary_dir;
  private final boolean                        debug_logging;

  /**
   * Construct connector parameters.
   *
   * @param in_package_name    The application package name
   * @param in_package_version The application package version
   * @param in_res             A resource provider
   * @param in_net             A net provider
   * @param in_device_serial   The serial number of the device
   * @param in_device_name     The name of the device
   * @param in_app_storage     The path to application storage
   * @param in_xml_storage     The path to XML storage
   * @param in_book_path       The path to fulfilled books
   * @param in_temporary_dir   A directory usable for temporary private file
   *                           storage (such as the per-application Android
   *                           external cache directory).
   * @param in_logging         {@code true} iff debug logging should initially
   *                           be enabled
   */

  public AdobeAdeptConnectorParameters(
    final String in_package_name,
    final String in_package_version,
    final AdobeAdeptResourceProviderType in_res,
    final AdobeAdeptNetProviderType in_net,
    final String in_device_serial,
    final String in_device_name,
    final File in_app_storage,
    final File in_xml_storage,
    final File in_book_path,
    final File in_temporary_dir,
    final boolean in_logging)
  {
    this.app_storage = NullCheck.notNull(in_app_storage);
    this.package_name = NullCheck.notNull(in_package_name);
    this.package_version = NullCheck.notNull(in_package_version);
    this.res = NullCheck.notNull(in_res);
    this.net = NullCheck.notNull(in_net);
    this.device_serial = NullCheck.notNull(in_device_serial);
    this.device_name = NullCheck.notNull(in_device_name);
    this.xml_storage = NullCheck.notNull(in_xml_storage);
    this.book_path = NullCheck.notNull(in_book_path);
    this.temporary_dir = NullCheck.notNull(in_temporary_dir);
    this.debug_logging = in_logging;
  }

  /**
   * @return {@code true} if debug logging should be left enabled after
   * initialization
   */

  public boolean isDebugLogging()
  {
    return this.debug_logging;
  }

  /**
   * @return The path to application storage
   */

  public File getApplicationStorage()
  {
    return this.app_storage;
  }

  /**
   * @return The path to fulfilled books
   */

  public File getBookPath()
  {
    return this.book_path;
  }

  /**
   * @return The name of the device
   */

  public String getDeviceName()
  {
    return this.device_name;
  }

  /**
   * @return The serial number of the device
   */

  public String getDeviceSerial()
  {
    return this.device_serial;
  }

  /**
   * @return The net provider
   */

  public AdobeAdeptNetProviderType getNetProvider()
  {
    return this.net;
  }

  /**
   * @return The application package name
   */

  public String getPackageName()
  {
    return this.package_name;
  }

  /**
   * @return The application package version
   */

  public String getPackageVersion()
  {
    return this.package_version;
  }

  /**
   * @return The resource provider
   */

  public AdobeAdeptResourceProviderType getResourceProvider()
  {
    return this.res;
  }

  /**
   * @return A directory usable for temporary private file storage (such as the
   * per-application Android external cache directory).
   */

  public File getTemporaryDirectory()
  {
    return this.temporary_dir;
  }

  /**
   * @return The path to XML storage
   */

  public File getXMLStorageDirectory()
  {
    return this.xml_storage;
  }
}
