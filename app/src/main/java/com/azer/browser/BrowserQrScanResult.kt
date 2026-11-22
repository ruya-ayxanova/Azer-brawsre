package com.azer.browser

data class BrowserQrScanResult(
    val rawValue: String,
    val type: BrowserQrType,
    val valid: Boolean,
    val url: String? = null,
    val message: String? = null
)
