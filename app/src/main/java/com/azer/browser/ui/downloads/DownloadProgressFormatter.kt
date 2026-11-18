package com.azer.browser.ui.downloads

object DownloadProgressFormatter {

    fun percent(record: Int): String {
        return "${record.coerceIn(0, 100)}%"
    }

    fun size(downloaded: Long, total: Long): String {
        if (total <= 0L) {
            return DownloadSizeFormatter.format(downloaded)
        }

        return "${DownloadSizeFormatter.format(downloaded)} / ${DownloadSizeFormatter.format(total)}"
    }
}
