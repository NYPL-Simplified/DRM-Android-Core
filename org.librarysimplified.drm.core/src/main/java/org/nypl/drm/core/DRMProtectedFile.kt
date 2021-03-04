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

  val adobeRightsFile: File?
) : PublicationAsset by fileAsset
