
package com.azer.browser.media

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

class MediaRepository(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_media",
        Context.MODE_PRIVATE
    )

    fun save(item: MediaItem) {
        val items = getAll().toMutableList()

        if (items.any { it.url == item.url }) return

        items.add(item)
        val array = JSONArray()

        items.takeLast(300).forEach {
            array.put(JSONObject().apply {
                put("url", it.url)
                put("title", it.title)
                put("type", it.type.name)
                put("size", it.size)
            })
        }

        prefs.edit()
            .putString("items", array.toString())
            .apply()
    }

    fun getAll(): List<MediaItem> {
        val result = mutableListOf<MediaItem>()
        val array = JSONArray(
            prefs.getString("items", "[]")
        )

        for (i in 0 until array.length()) {
            val item = array.getJSONObject(i)

            val type = runCatching {
                MediaType.valueOf(item.optString("type"))
            }.getOrDefault(MediaType.UNKNOWN)

            result.add(
                MediaItem(
                    item.optString("url"),
                    item.optString("title"),
                    type,
                    item.optLong("size", -1L)
                )
            )
        }

        return result
    }

    fun clear() {
        prefs.edit().remove("items").apply()
    }
}
