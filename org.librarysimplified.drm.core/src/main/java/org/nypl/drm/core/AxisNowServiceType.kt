package org.nypl.drm.core

import java.io.File

interface AxisNowServiceType {

    fun fulfill(token: ByteArray, tempFactory: () -> File): AxisNowFulfillment
}