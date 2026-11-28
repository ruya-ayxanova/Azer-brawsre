package com.azer.browser

data class BrowserResponseInfo51(
    val url: String,
    val statusCode: Int,
    val mimeType: String?,
    val contentLength: Long,
    val receivedAt: Long = System.currentTimeMillis()
)
