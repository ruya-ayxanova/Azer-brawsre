package com.azer.browser

object BrowserDoNotTrack {

    const val HEADER_NAME = "DNT"
    const val HEADER_VALUE = "1"

    fun headers(enabled: Boolean): Map<String, String> {
        return if (enabled) {
            mapOf(HEADER_NAME to HEADER_VALUE)
        } else {
            emptyMap()
        }
    }
}
