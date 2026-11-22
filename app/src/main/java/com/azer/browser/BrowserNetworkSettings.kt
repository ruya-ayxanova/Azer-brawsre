package com.azer.browser

data class BrowserNetworkSettings(
    val showOfflineWarning: Boolean = true,
    val autoReloadOnReconnect: Boolean = false,
    val dataSaverEnabled: Boolean = false,
    val monitorConnection: Boolean = true
)
