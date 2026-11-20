
package com.azer.browser

class BrowserHistoryCleaner(
    private val repository: BrowserHistoryRepository,
    private val settings: BrowserHistorySettings
) {

    fun cleanOldEntries() {
        val entries = repository.getAll()

        if (entries.size <= settings.maxEntries) return

        val keep = entries
            .sortedByDescending { it.visitedAt }
            .take(settings.maxEntries)

        val keepIds = keep.map { it.id }.toSet()

        entries.forEach {
            if (it.id !in keepIds) {
                repository.delete(it.id)
            }
        }
    }

    fun clearAll() {
        repository.clear()
    }
}
