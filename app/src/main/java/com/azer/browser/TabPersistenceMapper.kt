package com.azer.browser

object TabPersistenceMapper {

    fun fromTab(tab: BrowserTab): TabPersistenceRecord {
        return TabPersistenceRecord(
            id = tab.id,
            title = tab.title,
            url = tab.url,
            isActive = tab.isActive,
            createdAt = tab.createdAt,
            lastAccessedAt = tab.lastAccessedAt
        )
    }

    fun toTab(record: TabPersistenceRecord): BrowserTab {
        return BrowserTab(
            id = record.id,
            title = record.title,
            url = record.url,
            isActive = record.isActive,
            isLoading = false,
            createdAt = record.createdAt,
            lastAccessedAt = record.lastAccessedAt
        )
    }

    fun fromTabs(
        tabs: List<BrowserTab>
    ): List<TabPersistenceRecord> {
        return tabs.map { fromTab(it) }
    }

    fun toTabs(
        records: List<TabPersistenceRecord>
    ): List<BrowserTab> {
        return records.map { toTab(it) }
    }
}
