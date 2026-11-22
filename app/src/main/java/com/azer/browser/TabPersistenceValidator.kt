package com.azer.browser

object TabPersistenceValidator {

    fun isValid(record: TabPersistenceRecord): Boolean {
        return record.id.isNotBlank() &&
                record.title.isNotBlank() &&
                record.createdAt >= 0L &&
                record.lastAccessedAt >= 0L
    }

    fun isValidUrl(url: String): Boolean {
        return url.isBlank() ||
                url.startsWith("https://") ||
                url.startsWith("http://")
    }

    fun validateRecords(
        records: List<TabPersistenceRecord>
    ): List<TabPersistenceRecord> {

        return records
            .filter { isValid(it) && isValidUrl(it.url) }
            .distinctBy { it.id }
            .take(TabPersistenceConstants.MAX_SAVED_TABS)
    }
}
