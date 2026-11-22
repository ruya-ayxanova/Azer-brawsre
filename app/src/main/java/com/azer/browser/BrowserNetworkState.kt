package com.azer.browser

data class BrowserNetworkState(
    val connected: Boolean = false,
    val internetAvailable: Boolean = false,
    val networkType: BrowserNetworkType = BrowserNetworkType.NONE,
    val metered: Boolean = false,
    val timestamp: Long = System.currentTimeMillis()
)
