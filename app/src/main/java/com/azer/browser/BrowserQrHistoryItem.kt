package com.azer.browser

data class BrowserQrHistoryItem(
    val content: String,
    val type: BrowserQrType,
    val timestamp: Long = System.currentTimeMillis()
)
