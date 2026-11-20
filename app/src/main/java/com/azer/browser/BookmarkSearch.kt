
package com.azer.browser

object BookmarkSearch {

    fun filter(
        bookmarks: List<Bookmark>,
        query: String
    ): List<Bookmark> {
        val search = query.trim()

        if (search.isEmpty()) return bookmarks

        return bookmarks.filter {
            it.title.contains(search, ignoreCase = true) ||
                it.url.contains(search, ignoreCase = true)
        }
    }

    fun filterByFolder(
        bookmarks: List<Bookmark>,
        folderId: String
    ): List<Bookmark> {
        return bookmarks.filter {
            it.folderId == folderId
        }
    }
}
