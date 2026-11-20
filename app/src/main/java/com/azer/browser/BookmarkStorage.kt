
package com.azer.browser

import android.content.Context

class BookmarkStorage(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_bookmark_storage",
        Context.MODE_PRIVATE
    )

    fun readBookmarks(): String {
        return prefs.getString("bookmarks", "[]") ?: "[]"
    }

    fun writeBookmarks(json: String) {
        prefs.edit().putString("bookmarks", json).apply()
    }

    fun readFolders(): String {
        return prefs.getString("folders", "[]") ?: "[]"
    }

    fun writeFolders(json: String) {
        prefs.edit().putString("folders", json).apply()
    }

    fun clearBookmarks() {
        prefs.edit().remove("bookmarks").apply()
    }

    fun clearFolders() {
        prefs.edit().remove("folders").apply()
    }
}
