package com.azer.browser

object BrowserNetworkQualityChecker {

    fun evaluate(
        state: BrowserNetworkState,
        downloadSpeedMbps: Double? = null
    ): BrowserConnectionQuality {

        if (!state.internetAvailable) {
            return BrowserConnectionQuality.OFFLINE
        }

        if (downloadSpeedMbps == null) {
            return BrowserConnectionQuality.UNKNOWN
        }

        return when {
            downloadSpeedMbps < 1.0 ->
                BrowserConnectionQuality.WEAK

            downloadSpeedMbps < 5.0 ->
                BrowserConnectionQuality.NORMAL

            else ->
                BrowserConnectionQuality.GOOD
        }
    }
}
