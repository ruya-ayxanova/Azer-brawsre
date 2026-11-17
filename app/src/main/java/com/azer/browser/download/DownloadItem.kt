
package com.azer.browser.download

data class DownloadItem(
    val id: Long,
    val fileName: String,
    val url: String,
    val status: String,
    val progress: Int
)
