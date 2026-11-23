package com.azer.browser

object BrowserSessionTabAdder40 {

    fun add(
        session: BrowserSession40,
        tabId: String
    ): BrowserSession40 {

        if (tabId.isBlank()) return session

        if (tabId in session.tabIds) return session

        if (session.tabIds.size >=
            BrowserSessionConstants40.MAX_SESSION_TABS
        ) return session

        val updatedTabs = session.tabIds + tabId

        return session.copy(
            tabIds = updatedTabs,
            activeTabId = tabId,
            updatedAt = System.currentTimeMillis()
        )
    }
}
