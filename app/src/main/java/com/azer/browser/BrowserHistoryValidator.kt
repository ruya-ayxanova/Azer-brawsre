
package com.azer.browser

import android.util.Patterns

object BrowserHistoryValidator {

    fun isValidUrl(url: String): Boolean {
        return url.startsWith("http://") ||
            url.startsWith("https://")
    }

    fun isValidEntry(entry: BrowserHistoryEntry): Boolean {
        return entry.id.isNotBlank() &&
            entry.url.isNotBlank() &&
            Patterns.WEB_URL.matcher(entry.url).matches()
    }

    fun cleanTitle(title: String): String {
        return title.trim().ifBlank { "Başlıksız sayfa" }
    }
}
