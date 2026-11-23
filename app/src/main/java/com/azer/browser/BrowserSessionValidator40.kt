package com.azer.browser

object BrowserSessionValidator40 {

    fun isValid(session: BrowserSession40): Boolean {
        if (session.sessionId.isBlank()) return false

        if (session.tabIds.size >
            BrowserSessionConstants40.MAX_SESSION_TABS
        ) return false

        if (session.tabIds.distinct().size !=
            session.tabIds.size
        ) return false

        if (session.tabIds.any { it.isBlank() }) return false

        val activeId = session.activeTabId

        if (activeId != null &&
            activeId !in session.tabIds
        ) return false

        return true
    }

    fun hasTabs(session: BrowserSession40): Boolean {
        return session.tabIds.isNotEmpty()
    }
}
