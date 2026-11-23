package com.azer.browser

object BrowserSessionTabRemover40 {

    fun remove(
        session: BrowserSession40,
        tabId: String
    ): BrowserSession40 {

        val updatedTabs = session.tabIds.filter {
            it != tabId
        }

        val newActiveId = when {
            session.activeTabId != tabId ->
                session.activeTabId

            else -> updatedTabs.firstOrNull()
        }

        return session.copy(
            tabIds = updatedTabs,
            activeTabId = newActiveId,
            updatedAt = System.currentTimeMillis()
        )
    }
}
