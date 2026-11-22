package com.azer.browser

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

class BrowserQrHistoryRepository(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_qr_history",
        Context.MODE_PRIVATE
    )

    fun getAll(): List<BrowserQrHistoryItem> {
        val json = prefs.getString("items", "[]") ?: "[]"
        val result = mutableListOf<BrowserQrHistoryItem>()

        try {
            val array = JSONArray(json)

            for (i in 0 until array.length()) {
                val item = array.getJSONObject(i)

                result.add(
                    BrowserQrHistoryItem(
                        content = item.optString("content"),
                        type = runCatching {
                            BrowserQrType.valueOf(
                                item.optString("type", "UNKNOWN")
                            )
                        }.getOrDefault(BrowserQrType.UNKNOWN),
                        timestamp = item.optLong("timestamp")
                    )
                )
            }
        } catch (_: Exception) {
        }

        return result
    }

    fun add(item: BrowserQrHistoryItem) {
        val items = getAll().toMutableList()

        items.removeAll {
            it.content == item.content
        }

        items.add(0, item)

        val array = JSONArray()

        items.take(BrowserQrConstants.HISTORY_LIMIT).forEach {
            array.put(
                JSONObject().apply {
                    put("content", it.content)
                    put("type", it.type.name)
                    put("timestamp", it.timestamp)
                }
            )
        }

        prefs.edit().putString("items", array.toString()).apply()
    }

    fun delete(content: String) {
        val items = getAll().filterNot {
            it.content == content
        }

        saveItems(items)
    }

    fun clear() {
        prefs.edit().remove("items").apply()
    }

    private fun saveItems(items: List<BrowserQrHistoryItem>) {
        val array = JSONArray()

        items.forEach {
            array.put(
                JSONObject().apply {
                    put("content", it.content)
                    put("type", it.type.name)
                    put("timestamp", it.timestamp)
                }
            )
        }

        prefs.edit().putString("items", array.toString()).apply()
    }
}
