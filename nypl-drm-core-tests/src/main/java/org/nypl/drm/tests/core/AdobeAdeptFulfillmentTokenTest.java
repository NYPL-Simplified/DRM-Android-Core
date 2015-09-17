package org.nypl.drm.tests.core;

import android.test.InstrumentationTestCase;
import junit.framework.Assert;
import org.nypl.drm.core.AdobeAdeptFulfillmentToken;

import java.io.InputStream;

/**
 * ACSM fulfillment token tests.
 */

public final class AdobeAdeptFulfillmentTokenTest
  extends InstrumentationTestCase
{
  /**
   * Construct test suite.
   */

  public AdobeAdeptFulfillmentTokenTest()
  {

  }

  /**
   * Parsing a valid token works.
   *
   * @throws Exception On errors
   */

  public void testParse0()
    throws Exception
  {
    final InputStream s =
      AdobeAdeptFulfillmentTokenTest.class.getResourceAsStream("valid0.acsm");

    final AdobeAdeptFulfillmentToken token =
      AdobeAdeptFulfillmentToken.parseFromStream(s);
    Assert.assertEquals("application/epub+zip", token.getFormat());
  }
}
