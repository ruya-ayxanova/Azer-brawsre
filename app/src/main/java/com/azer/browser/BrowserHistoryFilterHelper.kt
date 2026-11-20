
package com.azer.browser

object BrowserHistoryFilterHelper {

    fun filter(
        entries: List<BrowserHistoryEntry>,
        filter: BrowserHistoryFilter
    ): List<BrowserHistoryEntry> {

        val now = System.currentTimeMillis()
        val today = BrowserHistoryDateHelper.todayStart()

        return when (filter) {

            BrowserHistoryFilter.ALL -> entries

            BrowserHistoryFilter.TODAY ->
                entries.filter { it.visitedAt >= today }

            BrowserHistoryFilter.YESTERDAY ->
                entries.filter {
                    it.visitedAt >= today - 86400000L &&
                    it.visitedAt < today
                }

            BrowserHistoryFilter.LAST_7_DAYS ->
                entries.filter {
                    it.visitedAt >= now - 7L * 86400000L
                }

            BrowserHistoryFilter.LAST_30_DAYS ->
                entries.filter {
                    it.visitedAt >= now - 30L * 86400000L
                }
        }
    }
}
