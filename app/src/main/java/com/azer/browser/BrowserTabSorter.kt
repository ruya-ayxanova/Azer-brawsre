package com.azer.browser

object BrowserTabSorter {

    fun byNewest(
        tabs: List<BrowserTab>
    ): List<BrowserTab> {
        return tabs.sortedByDescending {
            it.createdAt
        }
    }

    fun byLastAccess(
        tabs: List<BrowserTab>
    ): List<BrowserTab> {
        return tabs.sortedByDescending {
            it.lastAccessedAt
        }
    }

    fun byTitle(
        tabs: List<BrowserTab>
    ): List<BrowserTab> {
        return tabs.sortedBy {
            it.title.lowercase()
        }
    }
}
