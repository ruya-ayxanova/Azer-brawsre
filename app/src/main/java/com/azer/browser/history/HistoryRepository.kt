
package com.azer.browser.history

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

class HistoryRepository(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_history",
        Context.MODE_PRIVATE
    )

    fun add(title: String, url: String, isPrivate: Boolean = false) {
        if (isPrivate) return

        val list = getAll().toMutableList()

        list.add(
            HistoryItem(title, url, System.currentTimeMillis())
        )

        save(list.takeLast(1000))
    }

    fun getAll(): List<HistoryItem> {
        val result = mutableListOf<HistoryItem>()
        val array = JSONArray(prefs.getString("items", "[]"))

        for (i in 0 until array.length()) {
            val item = array.getJSONObject(i)

            result.add(
                HistoryItem(
                    item.optString("title"),
                    item.optString("url"),
                    item.optLong("visitedAt")
                )
            )
        }

        return result.reversed()
    }

    fun clear() {
        prefs.edit().remove("items").apply()
    }

    private fun save(list: List<HistoryItem>) {
        val array = JSONArray()

        list.forEach {
            array.put(
                JSONObject().apply {
                    put("title", it.title)
                    put("url", it.url)
                    put("visitedAt", it.visitedAt)
                }
            )
        }

        prefs.edit().putString("items", array.toString()).apply()
    }
}
