package org.nypl.drm.core

import org.readium.r2.shared.publication.asset.FileAsset
import org.readium.r2.shared.publication.asset.PublicationAsset
import java.io.File

/**
 * A Readium2 DRM-protected asset.
 */

class DRMProtectedFile(

  /**
   * The actual EPUB file.
   */

  val fileAsset: FileAsset,

  /**
   * The Adobe rights file, assuming there is one.
   */

  val adobeRightsFile: File? = null,

  /**
   * The Axis license file, assuming there is one.
   */

  val axisLicense: File? = null,

  /**
   * The Axis user key file, assuming there is one.
   */

  val axisUserKey: File? = null,

) : PublicationAsset by fileAsset
