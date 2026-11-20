
package com.azer.browser

object BrowserHistoryGroupHelper {

    fun groupByDay(
        entries: List<BrowserHistoryEntry>
    ): List<BrowserHistoryDay> {

        return entries
            .sortedByDescending { it.visitedAt }
            .groupBy {
                BrowserHistoryDateHelper.formatDate(it.visitedAt)
            }
            .map { (date, items) ->
                BrowserHistoryDay(
                    dateKey = date,
                    entries = items
                )
            }
        }
}
