package com.azer.browser.download.system

data class DownloadRequestInfo(
    val url: String,
    val userAgent: String?,
    val contentDisposition: String?,
    val mimeType: String?,
    val cookies: String?
)
