package com.azer.browser

object BrowserNotificationSearch {

    fun search(
        items: List<BrowserNotification>,
        query: String
    ): List<BrowserNotification> {

        if (query.isBlank()) return items

        val text = query.trim().lowercase()

        return items.filter {
            it.title.lowercase().contains(text) ||
                it.message.lowercase().contains(text) ||
                it.host.lowercase().contains(text)
        }
    }
}
