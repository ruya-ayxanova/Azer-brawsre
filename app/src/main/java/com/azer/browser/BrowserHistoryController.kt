
package com.azer.browser

import android.content.Context

class BrowserHistoryController(context: Context) {

    val repository = BrowserHistoryRepository(context)

    private val settings = BrowserHistorySettings(context)

    private val cleaner = BrowserHistoryCleaner(
        repository,
        settings
    )

    private var currentFilter = BrowserHistoryFilter.ALL
    private var currentSort = BrowserHistorySort.NEWEST
    private var searchQuery = ""

    fun addVisit(title: String, url: String) {
        if (!settings.enabled) return

        repository.add(title, url)
        cleaner.cleanOldEntries()
    }

    fun getEntries(): List<BrowserHistoryEntry> {
        var result = repository.getAll()

        result = BrowserHistoryFilterHelper.filter(
            result,
            currentFilter
        )

        result = BrowserHistorySearch.search(
            result,
            searchQuery
        )

        result = BrowserHistorySorter.sort(
            result,
            currentSort
        )

        return result
    }

    fun setFilter(filter: BrowserHistoryFilter) {
        currentFilter = filter
    }

    fun setSort(sort: BrowserHistorySort) {
        currentSort = sort
    }

    fun search(query: String) {
        searchQuery = query
    }

    fun deleteEntry(id: String) {
        repository.delete(id)
    }

    fun clearHistory() {
        cleaner.clearAll()
    }

    fun isEnabled(): Boolean {
        return settings.enabled
    }

    fun setEnabled(value: Boolean) {
        settings.enabled = value
    }

    fun totalCount(): Int {
        return repository.count()
    }
}
