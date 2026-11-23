package com.azer.browser

object BrowserSessionCleaner40 {

    fun clear(
        session: BrowserSession40
    ): BrowserSession40 {

        return session.copy(
            tabIds = emptyList(),
            activeTabId = null,
            updatedAt = System.currentTimeMillis()
        )
    }

    fun reset(): BrowserSession40 {
        return BrowserSessionFactory40.create()
    }
}
