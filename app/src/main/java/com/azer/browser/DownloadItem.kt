package com.azer.browser

data class DownloadItem(
    val id: Long,
    val title: String,
    val url: String,
    val fileName: String,
    val filePath: String = "",
    val status: DownloadStatus = DownloadStatus.PENDING,
    val progress: Int = 0,
    val totalBytes: Long = 0,
    val downloadedBytes: Long = 0,
    val createdAt: Long = System.currentTimeMillis()
)
