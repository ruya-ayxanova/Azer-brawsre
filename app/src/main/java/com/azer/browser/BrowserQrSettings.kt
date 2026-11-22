package com.azer.browser

data class BrowserQrSettings(
    val saveHistory: Boolean = true,
    val autoOpenLinks: Boolean = false,
    val vibrateOnScan: Boolean = true,
    val showConfirmation: Boolean = true
)
