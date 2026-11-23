package com.azer.browser

object BrowserSessionSelector40 {

    fun select(
        session: BrowserSession40,
        tabId: String
    ): BrowserSession40 {

        if (tabId !in session.tabIds) {
            return session
        }

        return session.copy(
            activeTabId = tabId,
            updatedAt = System.currentTimeMillis()
        )
    }

    fun getActiveTab(
        session: BrowserSession40
    ): String? {
        return session.activeTabId
    }
}
