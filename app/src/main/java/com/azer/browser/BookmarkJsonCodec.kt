
package com.azer.browser

import org.json.JSONArray
import org.json.JSONObject

object BookmarkJsonCodec {

    fun encodeBookmarks(items: List<Bookmark>): String {
        val array = JSONArray()

        items.forEach { item ->
            val obj = JSONObject()
            obj.put("id", item.id)
            obj.put("title", item.title)
            obj.put("url", item.url)
            obj.put("folderId", item.folderId)
            obj.put("createdAt", item.createdAt)
            array.put(obj)
        }

        return array.toString()
    }

    fun decodeBookmarks(json: String): List<Bookmark> {
        return try {
            val array = JSONArray(json)
            val result = mutableListOf<Bookmark>()

            for (i in 0 until array.length()) {
                val obj = array.getJSONObject(i)

                result.add(
                    Bookmark(
                        id = obj.optString("id"),
                        title = obj.optString("title"),
                        url = obj.optString("url"),
                        folderId = obj.optString("folderId"),
                        createdAt = obj.optLong("createdAt")
                    )
                )
            }

            result
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun encodeFolders(items: List<BookmarkFolder>): String {
        val array = JSONArray()

        items.forEach { item ->
            val obj = JSONObject()
            obj.put("id", item.id)
            obj.put("name", item.name)
            obj.put("createdAt", item.createdAt)
            array.put(obj)
        }

        return array.toString()
    }

    fun decodeFolders(json: String): List<BookmarkFolder> {
        return try {
            val array = JSONArray(json)
            val result = mutableListOf<BookmarkFolder>()

            for (i in 0 until array.length()) {
                val obj = array.getJSONObject(i)

                result.add(
                    BookmarkFolder(
                        id = obj.optString("id"),
                        name = obj.optString("name"),
                        createdAt = obj.optLong("createdAt")
                    )
                )
            }

            result
        } catch (e: Exception) {
            emptyList()
        }
    }
}
