package org.nypl.drm.core

import org.readium.r2.shared.publication.asset.FileAsset
import org.readium.r2.shared.publication.asset.PublicationAsset
import java.io.File

class DRMProtectedFile(
  val fileAsset: FileAsset,
  val adobeRightsFile: File?
) : PublicationAsset by fileAsset
