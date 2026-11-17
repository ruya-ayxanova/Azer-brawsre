
package com.azer.browser.bookmarks

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

class BookmarkRepository(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_bookmarks",
        Context.MODE_PRIVATE
    )

    fun add(bookmark: Bookmark) {
        val list = getAll().toMutableList()

        if (list.any { it.url == bookmark.url }) return

        list.add(bookmark)
        save(list)
    }

    fun getAll(): List<Bookmark> {
        val result = mutableListOf<Bookmark>()
        val array = JSONArray(prefs.getString("items", "[]"))

        for (i in 0 until array.length()) {
            val item = array.getJSONObject(i)
            result.add(
                Bookmark(
                    item.optString("title"),
                    item.optString("url"),
                    item.optString("folder", "Genel")
                )
            )
        }

        return result
    }

    fun remove(url: String) {
        save(getAll().filterNot { it.url == url })
    }

    private fun save(list: List<Bookmark>) {
        val array = JSONArray()

        list.forEach {
            array.put(
                JSONObject().apply {
                    put("title", it.title)
                    put("url", it.url)
                    put("folder", it.folder)
                }
            )
        }

        prefs.edit().putString("items", array.toString()).apply()
    }
}
