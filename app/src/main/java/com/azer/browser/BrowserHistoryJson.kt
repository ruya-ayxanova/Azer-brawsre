
package com.azer.browser

import org.json.JSONArray
import org.json.JSONObject

object BrowserHistoryJson {

    fun encode(entries: List<BrowserHistoryEntry>): String {
        val array = JSONArray()

        entries.forEach {
            val obj = JSONObject()
            obj.put("id", it.id)
            obj.put("title", it.title)
            obj.put("url", it.url)
            obj.put("visitedAt", it.visitedAt)
            obj.put("visitCount", it.visitCount)
            array.put(obj)
        }

        return array.toString()
    }

    fun decode(json: String): List<BrowserHistoryEntry> {
        return try {
            val array = JSONArray(json)
            val result = mutableListOf<BrowserHistoryEntry>()

            for (i in 0 until array.length()) {
                val obj = array.getJSONObject(i)

                result.add(
                    BrowserHistoryEntry(
                        id = obj.optString("id"),
                        title = obj.optString("title"),
                        url = obj.optString("url"),
                        visitedAt = obj.optLong("visitedAt"),
                        visitCount = obj.optInt("visitCount", 1)
                    )
                )
            }

            result
        } catch (_: Exception) {
            emptyList()
        }
    }
}
