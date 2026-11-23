package com.azer.browser

object BrowserSessionUpdater40 {

    fun updateTabs(
        session: BrowserSession40,
        tabIds: List<String>
    ): BrowserSession40 {

        val uniqueTabs = tabIds.distinct()

        val activeId = if (
            session.activeTabId in uniqueTabs
        ) {
            session.activeTabId
        } else {
            uniqueTabs.firstOrNull()
        }

        return session.copy(
            tabIds = uniqueTabs,
            activeTabId = activeId,
            updatedAt = System.currentTimeMillis()
        )
    }

    fun updateActiveTab(
        session: BrowserSession40,
        tabId: String?
    ): BrowserSession40 {

        if (tabId != null && tabId !in session.tabIds) {
            return session
        }

        return session.copy(
            activeTabId = tabId,
            updatedAt = System.currentTimeMillis()
        )
    }
}
