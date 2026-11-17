
package com.azer.browser.media

import android.net.Uri

object MediaUrlValidator {

    fun isValid(url: String): Boolean {
        return try {
            val uri = Uri.parse(url)
            val scheme = uri.scheme?.lowercase()

            (scheme == "https" || scheme == "http") &&
                !uri.host.isNullOrBlank()
        } catch (e: Exception) {
            false
        }
    }
}
