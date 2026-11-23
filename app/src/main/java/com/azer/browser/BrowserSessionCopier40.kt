package com.azer.browser

object BrowserSessionCopier40 {

    fun copySession(
        session: BrowserSession40
    ): BrowserSession40 {

        return BrowserSession40(
            sessionId = java.util.UUID.randomUUID().toString(),
            createdAt = System.currentTimeMillis(),
            updatedAt = System.currentTimeMillis(),
            activeTabId = session.activeTabId,
            tabIds = session.tabIds.toList(),
            isPrivate = session.isPrivate
        )
    }
}
