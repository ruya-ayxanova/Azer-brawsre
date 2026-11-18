package com.azer.browser.ui.bookmarks

import android.content.Context

class BookmarkScreenController(context: Context) {

    private val store = BookmarkStore(context)

    fun getBookmarks(): List<Bookmark> {
        return store.getAll()
    }

    fun addBookmark(title: String, url: String): Boolean {
        return store.add(title, url)
    }

    fun removeBookmark(id: Long): Boolean {
        return store.remove(id)
    }

    fun isSaved(url: String): Boolean {
        return store.contains(url)
    }
}
