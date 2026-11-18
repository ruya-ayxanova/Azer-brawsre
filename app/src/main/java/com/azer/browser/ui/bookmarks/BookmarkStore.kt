package com.azer.browser.ui.bookmarks

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

class BookmarkStore(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_browser_bookmarks",
        Context.MODE_PRIVATE
    )

    private val key = "bookmarks"

    @Synchronized
    fun getAll(): List<Bookmark> {
        val json = prefs.getString(key, "[]") ?: "[]"
        val list = mutableListOf<Bookmark>()

        try {
            val array = JSONArray(json)

            for (i in 0 until array.length()) {
                val item = array.optJSONObject(i) ?: continue

                list.add(
                    Bookmark(
                        id = item.optLong("id"),
                        title = item.optString("title"),
                        url = item.optString("url"),
                        addedAt = item.optLong("addedAt")
                    )
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return list.sortedByDescending { it.addedAt }
    }

    @Synchronized
    fun add(title: String, url: String): Boolean {
        if (!BookmarkUrlValidator.isValid(url)) return false

        val normalized = BookmarkUrlValidator.normalize(url)

        if (getAll().any { it.url.equals(normalized, true) }) {
            return false
        }

        val list = getAll().toMutableList()

        list.add(
            Bookmark(
                id = System.currentTimeMillis(),
                title = BookmarkTitleResolver.resolve(title, normalized),
                url = normalized
            )
        )

        save(list)
        return true
    }

    @Synchronized
    fun remove(id: Long): Boolean {
        val list = getAll().toMutableList()
        val oldSize = list.size

        list.removeAll { it.id == id }

        if (list.size == oldSize) return false

        save(list)
        return true
    }

    fun contains(url: String): Boolean {
        val normalized = BookmarkUrlValidator.normalize(url)

        return getAll().any {
            it.url.equals(normalized, true)
        }
    }

    @Synchronized
    private fun save(list: List<Bookmark>) {
        val array = JSONArray()

        list.forEach { bookmark ->
            val item = JSONObject()

            item.put("id", bookmark.id)
            item.put("title", bookmark.title)
            item.put("url", bookmark.url)
            item.put("addedAt", bookmark.addedAt)

            array.put(item)
        }

        prefs.edit()
            .putString(key, array.toString())
            .apply()
    }
}
