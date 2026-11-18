package com.azer.browser

data class DownloadProgress(
    val downloadId: Long,
    val downloadedBytes: Long,
    val totalBytes: Long,
    val progress: Int,
    val status: DownloadStatus
) {
    companion object {
        fun calculate(
            id: Long,
            downloaded: Long,
            total: Long,
            status: DownloadStatus
        ): DownloadProgress {

            val percent = if (total > 0) {
                ((downloaded * 100) / total).toInt()
                    .coerceIn(0, 100)
            } else {
                0
            }

            return DownloadProgress(
                downloadId = id,
                downloadedBytes = downloaded,
                totalBytes = total,
                progress = percent,
                status = status
            )
        }
    }
}
