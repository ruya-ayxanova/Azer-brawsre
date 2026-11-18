package com.azer.browser.ui.bookmarks

class BookmarkOpenHandler {

    fun getUrl(bookmark: Bookmark): String? {
        val url = bookmark.url.trim()

        if (!BookmarkUrlValidator.isValid(url)) {
            return null
        }

        return url
    }
}
