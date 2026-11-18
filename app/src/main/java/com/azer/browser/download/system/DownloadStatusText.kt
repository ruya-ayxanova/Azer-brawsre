package com.azer.browser.download.system

object DownloadStatusText {

    fun get(state: DownloadState): String {
        return when (state) {
            DownloadState.PENDING -> "Bekliyor"
            DownloadState.RUNNING -> "İndiriliyor"
            DownloadState.PAUSED -> "Duraklatıldı"
            DownloadState.SUCCESSFUL -> "Tamamlandı"
            DownloadState.FAILED -> "Başarısız"
            DownloadState.UNKNOWN -> "Bilinmiyor"
        }
    }

    fun formatSize(bytes: Long): String {
        if (bytes < 0L) return "Bilinmiyor"

        val kb = bytes / 1024.0
        if (kb < 1024.0) {
            return String.format("%.1f KB", kb)
        }

        val mb = kb / 1024.0
        if (mb < 1024.0) {
            return String.format("%.1f MB", mb)
        }

        val gb = mb / 1024.0
        return String.format("%.2f GB", gb)
    }
}
