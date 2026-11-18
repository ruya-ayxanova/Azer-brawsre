package com.azer.browser.download.system

data class DownloadRecord(
    val id: Long,
    val fileName: String,
    val status: DownloadState,
    val downloadedBytes: Long,
    val totalBytes: Long
) {
    val progress: Int
        get() {
            if (totalBytes <= 0L) return 0
            return ((downloadedBytes * 100) / totalBytes)
                .toInt()
                .coerceIn(0, 100)
        }
}
