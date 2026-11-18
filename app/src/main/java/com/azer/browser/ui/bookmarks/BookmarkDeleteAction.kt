package com.azer.browser.ui.bookmarks

class BookmarkDeleteAction(
    private val store: BookmarkStore
) {

    fun delete(bookmark: Bookmark): Boolean {
        return store.remove(bookmark.id)
    }

    fun deleteAll(): Int {
        val items = store.getAll()
        var deleted = 0

        items.forEach {
            if (store.remove(it.id)) {
                deleted++
            }
        }

        return deleted
    }
}
