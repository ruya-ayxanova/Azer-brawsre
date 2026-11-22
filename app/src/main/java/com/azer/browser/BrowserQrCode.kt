package com.azer.browser

data class BrowserQrCode(
    val id: String,
    val content: String,
    val type: BrowserQrType,
    val createdAt: Long = System.currentTimeMillis()
)
