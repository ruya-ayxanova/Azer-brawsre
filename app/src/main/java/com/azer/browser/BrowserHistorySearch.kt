
package com.azer.browser

object BrowserHistorySearch {

    fun search(
        entries: List<BrowserHistoryEntry>,
        query: String
    ): List<BrowserHistoryEntry> {

        if (query.isBlank()) return entries

        val q = query.trim().lowercase()

        return entries.filter {
            it.title.lowercase().contains(q) ||
                it.url.lowercase().contains(q)
        }
    }
}
