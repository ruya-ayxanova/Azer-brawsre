
package com.azer.browser

import java.util.UUID

class BookmarkRepository(
    private val storage: BookmarkStorage
) {

    fun getAll(): List<Bookmark> {
        return BookmarkJsonCodec.decodeBookmarks(
            storage.readBookmarks()
        )
    }

    fun add(
        title: String,
        url: String,
        folderId: String
    ): Bookmark? {
        if (title.isBlank() || !BookmarkValidator.isValidUrl(url)) {
            return null
        }

        val items = getAll()

        if (items.any { it.url == url.trim() }) {
            return null
        }

        val bookmark = Bookmark(
            id = UUID.randomUUID().toString(),
            title = title.trim(),
            url = url.trim(),
            folderId = folderId
        )

        storage.writeBookmarks(
            BookmarkJsonCodec.encodeBookmarks(items + bookmark)
        )

        return bookmark
    }

    fun update(
        id: String,
        title: String,
        url: String
    ): Boolean {
        if (title.isBlank() || !BookmarkValidator.isValidUrl(url)) {
            return false
        }

        val items = getAll()
        val bookmark = items.find { it.id == id } ?: return false

        if (items.any { it.id != id && it.url == url.trim() }) {
            return false
        }

        bookmark.title = title.trim()
        bookmark.url = url.trim()

        storage.writeBookmarks(
            BookmarkJsonCodec.encodeBookmarks(items)
        )

        return true
    }

    fun delete(id: String): Boolean {
        val items = getAll()
        val updated = items.filterNot { it.id == id }

        if (updated.size == items.size) return false

        storage.writeBookmarks(
            BookmarkJsonCodec.encodeBookmarks(updated)
        )

        return true
    }

    fun moveToFolder(
        bookmarkId: String,
        folderId: String
    ): Boolean {
        val items = getAll()
        val bookmark = items.find { it.id == bookmarkId }
            ?: return false

        bookmark.folderId = folderId

        storage.writeBookmarks(
            BookmarkJsonCodec.encodeBookmarks(items)
        )

        return true
    }

    fun findById(id: String): Bookmark? {
        return getAll().find { it.id == id }
    }

    fun clear() {
        storage.clearBookmarks()
    }
}
