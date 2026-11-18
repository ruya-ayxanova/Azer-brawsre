package com.azer.browser.ui.downloads

import com.azer.browser.download.system.DownloadState

object DownloadStatusLabel {

    fun get(state: DownloadState): String {
        return when (state) {
            DownloadState.PENDING -> "Bekliyor"
            DownloadState.RUNNING -> "İndiriliyor"
            DownloadState.PAUSED -> "Duraklatıldı"
            DownloadState.SUCCESSFUL -> "Tamamlandı"
            DownloadState.FAILED -> "Hata"
            DownloadState.UNKNOWN -> "Bilinmiyor"
        }
    }
}
