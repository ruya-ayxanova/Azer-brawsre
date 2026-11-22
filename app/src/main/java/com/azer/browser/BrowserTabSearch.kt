package com.azer.browser

object BrowserTabSearch {

    fun search(
        tabs: List<BrowserTab>,
        query: String
    ): List<BrowserTab> {

        if (query.isBlank()) return tabs

        val text = query.trim().lowercase()

        return tabs.filter {
            it.title.lowercase().contains(text) ||
            it.url.lowercase().contains(text)
        }
    }
}
