package com.azer.browser.download.system

import android.webkit.URLUtil

object DownloadFileName {

    fun create(
        url: String,
        contentDisposition: String?,
        mimeType: String?
    ): String {
        val suggested = URLUtil.guessFileName(
            url,
            contentDisposition,
            mimeType
        )

        val safe = suggested
            .replace(Regex("[\\\\/:*?\"<>|]"), "_")
            .trim()
            .take(180)

        return safe.ifBlank { "azer_download" }
    }
}
