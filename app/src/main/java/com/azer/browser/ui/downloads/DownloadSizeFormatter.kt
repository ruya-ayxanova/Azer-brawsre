package com.azer.browser.ui.downloads

object DownloadSizeFormatter {

    fun format(bytes: Long): String {
        if (bytes < 0L) return "Bilinmiyor"

        if (bytes < 1024L) {
            return "$bytes B"
        }

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
