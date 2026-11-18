
package com.azer.browser

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

class HomePageRepository(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_home_data",
        Context.MODE_PRIVATE
    )

    fun getShortcuts(): List<HomeShortcut> {
        val saved = prefs.getString("shortcuts", null)

        if (saved == null) {
            return defaultShortcuts()
        }

        return try {
            val array = JSONArray(saved)
            val result = mutableListOf<HomeShortcut>()

            for (i in 0 until array.length()) {
                val item = array.getJSONObject(i)
                result.add(
                    HomeShortcut(
                        item.optString("title"),
                        item.optString("url")
                    )
                )
            }

            result
        } catch (e: Exception) {
            defaultShortcuts()
        }
    }

    fun saveShortcuts(items: List<HomeShortcut>) {
        val array = JSONArray()

        items.forEach {
            val obj = JSONObject()
            obj.put("title", it.title)
            obj.put("url", it.url)
            array.put(obj)
        }

        prefs.edit().putString("shortcuts", array.toString()).apply()
    }

    fun addShortcut(shortcut: HomeShortcut) {
        val items = getShortcuts().toMutableList()

        if (items.none { it.url == shortcut.url }) {
            items.add(shortcut)
            saveShortcuts(items)
        }
    }

    fun removeShortcut(url: String) {
        saveShortcuts(getShortcuts().filterNot { it.url == url })
    }

    fun getRecentPages(): List<HomePageItem> {
        val saved = prefs.getString("recent_pages", null)
            ?: return emptyList()

        return try {
            val array = JSONArray(saved)
            val result = mutableListOf<HomePageItem>()

            for (i in 0 until array.length()) {
                val item = array.getJSONObject(i)

                result.add(
                    HomePageItem(
                        title = item.optString("title"),
                        url = item.optString("url"),
                        visitedAt = item.optLong("visitedAt")
                    )
                )
            }

            result.sortedByDescending { it.visitedAt }
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun addRecentPage(title: String, url: String) {
        if (url.isBlank()) return

        val pages = getRecentPages()
            .filterNot { it.url == url }
            .toMutableList()

        pages.add(
            0,
            HomePageItem(
                title = title.ifBlank { url },
                url = url
            )
        )

        saveRecentPages(pages.take(20))
    }

    fun clearRecentPages() {
        prefs.edit().remove("recent_pages").apply()
    }

    private fun saveRecentPages(items: List<HomePageItem>) {
        val array = JSONArray()

        items.forEach {
            val obj = JSONObject()
            obj.put("title", it.title)
            obj.put("url", it.url)
            obj.put("visitedAt", it.visitedAt)
            array.put(obj)
        }

        prefs.edit()
            .putString("recent_pages", array.toString())
            .apply()
    }

    private fun defaultShortcuts(): List<HomeShortcut> {
        return listOf(
            HomeShortcut("Google", "https://www.google.com"),
            HomeShortcut("YouTube", "https://www.youtube.com"),
            HomeShortcut("Wikipedia", "https://www.wikipedia.org"),
            HomeShortcut("Facebook", "https://www.facebook.com")
        )
    }
}
