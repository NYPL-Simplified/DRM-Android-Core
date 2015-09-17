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

package org.nypl.drm.tests.core;

import android.test.InstrumentationTestCase;
import junit.framework.Assert;
import org.nypl.drm.core.AdobeAdeptACSMUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ACSM utility tests.
 */

public final class AdobeAdeptACSMUtilitiesTest extends InstrumentationTestCase
{
  private static final Logger LOG;

  static {
    LOG = LoggerFactory.getLogger(AdobeAdeptACSMUtilitiesTest.class);
  }

  /**
   * Construct test suite.
   */

  public AdobeAdeptACSMUtilitiesTest()
  {

  }

  /**
   * Parsing a success ACSM works.
   *
   * @throws Exception On errors
   */

  public void testSuccessful()
    throws Exception
  {
    final StringBuilder b = new StringBuilder(64);
    b.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
    b.append("<success xmlns=\"http://ns.adobe.com/adept\"/>\n");

    Assert.assertTrue(AdobeAdeptACSMUtilities.acsmIsSuccessful(b.toString()));
  }

  /**
   * Parsing a failure ACSM works.
   *
   * @throws Exception On errors
   */

  public void testNotSuccessful()
    throws Exception
  {
    final StringBuilder b = new StringBuilder(64);
    b.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
    b.append("<failure xmlns=\"http://ns.adobe.com/adept\"/>\n");

    Assert.assertFalse(AdobeAdeptACSMUtilities.acsmIsSuccessful(b.toString()));
  }

  /**
   * Parsing a broken ACSM fails.
   *
   * @throws Exception On errors
   */

  public void testParseError()
    throws Exception
  {
    final StringBuilder b = new StringBuilder(64);
    b.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
    b.append("<broken></unusable>\n");

    AdobeAdeptACSMUtilities.acsmIsSuccessful(b.toString());
  }
}
