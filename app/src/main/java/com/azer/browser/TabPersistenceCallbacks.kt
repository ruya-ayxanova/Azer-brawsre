package com.azer.browser

interface TabPersistenceCallbacks {

    fun onTabsSaved(
        result: TabPersistenceResult
    ) {}

    fun onTabsRestored(
        tabs: List<BrowserTab>
    ) {}

    fun onPersistenceError(
        message: String
    ) {}
}
