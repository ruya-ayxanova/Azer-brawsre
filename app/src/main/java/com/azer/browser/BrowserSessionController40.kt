package com.azer.browser

class BrowserSessionController40 {

    private val manager =
        BrowserSessionManager40()

    private val history =
        BrowserSessionHistoryManager40()

    private val events =
        BrowserSessionEventManager40()

    fun getCurrentSession(): BrowserSession40 {
        return manager.getSession()
    }

    fun openTab(tabId: String): BrowserSessionResult40 {

        val result = manager.addTab(tabId)

        history.add(
            result.session?.sessionId ?: "",
            BrowserSessionAction40.ADD_TAB,
            "Yeni sekme eklendi: $tabId"
        )

        events.record("TAB_ADDED:$tabId")

        return result
    }

    fun closeTab(tabId: String): BrowserSessionResult40 {

        val result = manager.removeTab(tabId)

        history.add(
            result.session?.sessionId ?: "",
            BrowserSessionAction40.REMOVE_TAB,
            "Sekme kapatıldı: $tabId"
        )

        events.record("TAB_REMOVED:$tabId")

        return result
    }

    fun switchTab(tabId: String): BrowserSessionResult40 {

        val result = manager.selectTab(tabId)

        history.add(
            result.session?.sessionId ?: "",
            BrowserSessionAction40.SWITCH,
            "Sekme değiştirildi: $tabId"
        )

        events.record("TAB_SWITCHED:$tabId")

        return result
    }

    fun getSummary(): BrowserSessionSummary40 {
        return BrowserSessionSummary40.from(
            manager.getSession()
        )
    }

    fun getHistory(): List<BrowserSessionHistory40> {
        return history.getHistory()
    }

    fun getEvents(): List<String> {
        return events.getEvents()
    }
}
