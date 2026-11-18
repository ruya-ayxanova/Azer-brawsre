package com.azer.browser.ui.bookmarks

object BookmarkTitleResolver {

    fun resolve(title: String?, url: String): String {
        val cleanTitle = title?.trim().orEmpty()

        if (cleanTitle.isNotEmpty()) {
            return cleanTitle
        }

        return try {
            android.net.Uri.parse(url).host ?: url
        } catch (e: Exception) {
            url
        }
    }
}
