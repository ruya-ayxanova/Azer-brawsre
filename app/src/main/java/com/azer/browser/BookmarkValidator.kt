
package com.azer.browser

object BookmarkValidator {

    fun isValidUrl(value: String): Boolean {
        val url = value.trim()

        if (url.isEmpty() || url.contains(" ")) return false

        return try {
            val uri = java.net.URI(url)
            val scheme = uri.scheme?.lowercase()

            (scheme == "http" || scheme == "https") &&
                !uri.host.isNullOrBlank()
        } catch (e: Exception) {
            false
        }
    }

    fun isValidTitle(value: String): Boolean {
        return value.trim().isNotEmpty()
    }

    fun isValidFolderName(value: String): Boolean {
        return value.trim().isNotEmpty() &&
            value.trim().length <= 40
    }
}
