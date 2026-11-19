
package com.azer.browser

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

class BrowserTabStore(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_browser_tabs",
        Context.MODE_PRIVATE
    )

    fun save(tabs: List<BrowserTab>) {
        val array = JSONArray()

        tabs.forEach { tab ->
            val obj = JSONObject()
            obj.put("id", tab.id)
            obj.put("title", tab.title)
            obj.put("url", tab.url)
            obj.put("isActive", tab.isActive)
            array.put(obj)
        }

        prefs.edit().putString("tabs", array.toString()).apply()
    }

    fun load(): List<BrowserTab> {
        val data = prefs.getString("tabs", null)
            ?: return emptyList()

        return try {
            val array = JSONArray(data)
            val result = mutableListOf<BrowserTab>()

            for (i in 0 until array.length()) {
                val obj = array.getJSONObject(i)

                result.add(
                    BrowserTab(
                        id = obj.optString("id"),
                        title = obj.optString("title"),
                        url = obj.optString("url"),
                        isActive = obj.optBoolean("isActive")
                    )
                )
            }

            result
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun clear() {
        prefs.edit().remove("tabs").apply()
    }
}
