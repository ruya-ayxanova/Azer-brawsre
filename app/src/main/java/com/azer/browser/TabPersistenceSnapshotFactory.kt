package com.azer.browser

object TabPersistenceSnapshotFactory {

    fun create(
        tabs: List<BrowserTab>
    ): TabPersistenceSnapshot {

        val active = tabs.firstOrNull {
            it.isActive
        }

        return TabPersistenceSnapshot(
            tabs = TabPersistenceMapper.fromTabs(tabs),
            activeTabId = active?.id,
            savedAt = System.currentTimeMillis()
        )
    }
}
