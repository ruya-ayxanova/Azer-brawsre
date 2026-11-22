package com.azer.browser

data class BrowserNetworkStatus(
    val state: BrowserNetworkState,
    val quality: BrowserConnectionQuality,
    val displayName: String,
    val description: String
)
