package com.azer.browser

import android.content.Context

class TabPersistenceManager(context: Context) {

    private val repository =
        TabPersistenceRepository(context)

    fun saveTabs(
        tabs: List<BrowserTab>
    ): TabPersistenceResult {
        return repository.save(tabs)
    }

    fun restoreTabs(): List<BrowserTab> {

        val snapshot = repository.restore()
            ?: return emptyList()

        return TabPersistenceMapper.toTabs(
            snapshot.tabs
        )
    }

    fun clearSavedTabs() {
        repository.clear()
    }

    fun hasSavedTabs(): Boolean {
        return repository.hasSavedTabs()
    }

    fun lastSaveTime(): Long {
        return repository.getLastSaveTime()
    }
}
