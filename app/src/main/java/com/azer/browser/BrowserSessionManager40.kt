package com.azer.browser

class BrowserSessionManager40(
    initialSession: BrowserSession40 =
        BrowserSessionFactory40.create()
) {

    private var currentSession = initialSession

    fun getSession(): BrowserSession40 {
        return currentSession
    }

    fun addTab(tabId: String): BrowserSessionResult40 {

        currentSession =
            BrowserSessionTabAdder40.add(
                currentSession,
                tabId
            )

        return BrowserSessionResult40.success(
            currentSession,
            BrowserSessionStatus40.ACTIVE
        )
    }

    fun removeTab(tabId: String): BrowserSessionResult40 {

        currentSession =
            BrowserSessionTabRemover40.remove(
                currentSession,
                tabId
            )

        return BrowserSessionResult40.success(
            currentSession,
            BrowserSessionStatus40.ACTIVE
        )
    }

    fun selectTab(tabId: String): BrowserSessionResult40 {

        currentSession =
            BrowserSessionSelector40.select(
                currentSession,
                tabId
            )

        return BrowserSessionResult40.success(
            currentSession,
            BrowserSessionStatus40.ACTIVE
        )
    }

    fun clearSession(): BrowserSessionResult40 {

        currentSession =
            BrowserSessionCleaner40.clear(
                currentSession
            )

        return BrowserSessionResult40.success(
            currentSession,
            BrowserSessionStatus40.EMPTY
        )
    }
}
