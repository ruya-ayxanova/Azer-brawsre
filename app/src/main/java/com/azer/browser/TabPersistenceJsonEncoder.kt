package com.azer.browser

import org.json.JSONArray
import org.json.JSONObject

object TabPersistenceJsonEncoder {

    fun encode(
        snapshot: TabPersistenceSnapshot
    ): String {

        val root = JSONObject()
        val array = JSONArray()

        snapshot.tabs.forEach { tab ->

            val item = JSONObject()

            item.put("id", tab.id)
            item.put("title", tab.title)
            item.put("url", tab.url)
            item.put("active", tab.isActive)
            item.put("created", tab.createdAt)
            item.put("accessed", tab.lastAccessedAt)

            array.put(item)
        }

        root.put("version", TabPersistenceConstants.VERSION)
        root.put("activeTabId", snapshot.activeTabId ?: "")
        root.put("savedAt", snapshot.savedAt)
        root.put("tabs", array)

        return root.toString()
    }
}
