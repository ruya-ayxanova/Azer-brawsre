
package com.azer.browser

import android.util.Patterns

object BrowserAddressValidator {

    fun isWebAddress(value: String): Boolean {
        val text = value.trim()

        if (text.isEmpty() || text.contains(" ")) {
            return false
        }

        val candidate = when {
            text.startsWith("https://") ||
            text.startsWith("http://") -> text

            else -> "https://$text"
        }

        val host = try {
            java.net.URI(candidate).host
        } catch (e: Exception) {
            null
        }

        return host != null &&
            Patterns.WEB_URL.matcher(candidate).matches()
    }

    fun isEmpty(value: String): Boolean {
        return value.trim().isEmpty()
    }
}
