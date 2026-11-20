
package com.azer.browser

object BrowserHistorySorter {

    fun sort(
        entries: List<BrowserHistoryEntry>,
        sort: BrowserHistorySort
    ): List<BrowserHistoryEntry> {

        return when (sort) {
            BrowserHistorySort.NEWEST ->
                entries.sortedByDescending { it.visitedAt }

            BrowserHistorySort.OLDEST ->
                entries.sortedBy { it.visitedAt }

            BrowserHistorySort.MOST_VISITED ->
                entries.sortedByDescending { it.visitCount }
        }
    }
}
