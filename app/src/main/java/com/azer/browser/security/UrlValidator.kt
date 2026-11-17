
package com.azer.browser.security

import android.net.Uri

object UrlValidator {

    fun isSafe(url: String): Boolean {
        return try {
            val uri = Uri.parse(url)
            val scheme = uri.scheme?.lowercase()

            scheme == "https" || scheme == "http"
        } catch (e: Exception) {
            false
        }
    }
}
