package com.azer.browser

data class TabPersistenceSnapshot(
    val tabs: List<TabPersistenceRecord>,
    val activeTabId: String?,
    val savedAt: Long
)
