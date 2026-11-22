package com.azer.browser

import android.content.Context

class TabPersistenceRepository(context: Context) {

    private val storage = TabPersistenceStorage(context)

    fun save(
        tabs: List<BrowserTab>
    ): TabPersistenceResult {

        val limitedTabs = tabs.take(
            TabPersistenceConstants.MAX_SAVED_TABS
        )

        val snapshot =
            TabPersistenceSnapshotFactory.create(limitedTabs)

        val json =
            TabPersistenceJsonEncoder.encode(snapshot)

        val success = storage.saveJson(json)

        if (success) {
            storage.saveActiveTab(snapshot.activeTabId)
            storage.saveTime(snapshot.savedAt)
        }

        return TabPersistenceResult(
            success = success,
            message = if (success) {
                "Sekmeler kaydedildi"
            } else {
                "Sekmeler kaydedilemedi"
            },
            tabCount = limitedTabs.size
        )
    }

    fun restore(): TabPersistenceSnapshot? {

        val json = storage.getJson() ?: return null

        val snapshot =
            TabPersistenceJsonDecoder.decode(json)
                ?: return null

        val savedActiveId = storage.getActiveTab()

        val activeId = savedActiveId
            ?: snapshot.activeTabId
            ?: snapshot.tabs.firstOrNull()?.id

        val correctedTabs = snapshot.tabs.map { tab ->
            tab.copy(
                isActive = tab.id == activeId
            )
        }

        return snapshot.copy(
            tabs = correctedTabs,
            activeTabId = activeId
        )
    }

    fun clear(): Boolean {
        storage.clear()
        return true
    }

    fun hasSavedTabs(): Boolean {
        return !storage.getJson().isNullOrBlank()
    }

    fun getLastSaveTime(): Long {
        return storage.getSavedTime()
    }
}
