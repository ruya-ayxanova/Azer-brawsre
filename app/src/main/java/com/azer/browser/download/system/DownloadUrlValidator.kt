package com.azer.browser.download.system

import android.net.Uri

object DownloadUrlValidator {

    fun isValid(url: String): Boolean {
        return try {
            val uri = Uri.parse(url)
            val scheme = uri.scheme?.lowercase()
            !uri.host.isNullOrBlank() &&
                (scheme == "http" || scheme == "https")
        } catch (e: Exception) {
            false
        }
    }
}
