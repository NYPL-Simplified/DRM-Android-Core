package org.nypl.drm.core

import org.readium.r2.shared.publication.asset.FileAsset
import org.readium.r2.shared.publication.asset.PublicationAsset
import java.io.File

/**
 * A Readium2 AxisNow-protected asset.
 */

class AxisNowFileAsset(

    /**
     * The actual EPUB file.
     */

    val fileAsset: FileAsset,

    /**
     * The Axis license file, assuming there is one.
     */

    val axisLicense: File?,

    /**
     * The Axis user key file, assuming there is one.
     */

    val axisUserKey: File?,

) : PublicationAsset by fileAsset
