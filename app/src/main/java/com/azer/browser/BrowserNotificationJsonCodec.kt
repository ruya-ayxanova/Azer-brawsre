package com.azer.browser

import org.json.JSONArray
import org.json.JSONObject

object BrowserNotificationJsonCodec {

    fun encode(items: List<BrowserNotification>): String {
        val array = JSONArray()

        items.forEach {
            val obj = JSONObject()
            obj.put("id", it.id)
            obj.put("title", it.title)
            obj.put("message", it.message)
            obj.put("host", it.host)
            obj.put("createdAt", it.createdAt)
            obj.put("read", it.read)
            array.put(obj)
        }

        return array.toString()
    }

    fun decode(json: String): List<BrowserNotification> {
        return try {
            val array = JSONArray(json)
            val result = mutableListOf<BrowserNotification>()

            for (i in 0 until array.length()) {
                val obj = array.getJSONObject(i)

                result.add(
                    BrowserNotification(
                        id = obj.optString("id"),
                        title = obj.optString("title"),
                        message = obj.optString("message"),
                        host = obj.optString("host"),
                        createdAt = obj.optLong("createdAt"),
                        read = obj.optBoolean("read")
                    )
                )
            }

            result
        } catch (_: Exception) {
            emptyList()
        }
    }
}
