package com.azer.browser.ui.bookmarks

object BookmarkUrlValidator {

    fun isValid(url: String): Boolean {
        val value = url.trim()

        return value.startsWith("https://", true) ||
                value.startsWith("http://", true)
    }

    fun normalize(url: String): String {
        val value = url.trim()

        return when {
            value.startsWith("https://", true) -> value
            value.startsWith("http://", true) -> value
            else -> "https://$value"
        }
    }
}
