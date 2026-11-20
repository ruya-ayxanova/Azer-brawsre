
package com.azer.browser

import org.json.JSONArray

object BookmarkExportManager {

    fun export(bookmarks: List<Bookmark>): String {
        return BookmarkJsonCodec.encodeBookmarks(bookmarks)
    }

    fun import(json: String): List<Bookmark> {
        return try {
            val array = JSONArray(json)
            val parsed = BookmarkJsonCodec.decodeBookmarks(
                array.toString()
            )

            parsed.filter {
                it.id.isNotBlank() &&
                    it.title.isNotBlank() &&
                    BookmarkValidator.isValidUrl(it.url)
            }.distinctBy { it.url }
        } catch (e: Exception) {
            emptyList()
        }
    }
}
