package com.azer.browser

data class BrowserPrivacySettings(
    val trackingProtection: Boolean = true,
    val blockThirdPartyCookies: Boolean = true,
    val javascriptEnabled: Boolean = true,
    val cookiesEnabled: Boolean = true,
    val safeBrowsing: Boolean = true,
    val privateBrowsing: Boolean = false,
    val doNotTrack: Boolean = true
)
