package com.azer.browser

class TabPersistenceAutoSave(
    private val manager: TabPersistenceManager
) {

    fun onTabsChanged(
        tabs: List<BrowserTab>
    ): TabPersistenceResult {
        return manager.saveTabs(tabs)
    }

    fun onTabClosed(
        tabs: List<BrowserTab>
    ): TabPersistenceResult {
        return manager.saveTabs(tabs)
    }

    fun onTabSwitched(
        tabs: List<BrowserTab>
    ): TabPersistenceResult {
        return manager.saveTabs(tabs)
    }
}
