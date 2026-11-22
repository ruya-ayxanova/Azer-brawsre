package com.azer.browser

object TabReloadHelper38 {

    fun createRequest(
        tab: BrowserTab
    ): TabReloadRequest38? {

        if (tab.url.isBlank()) return null

        return TabReloadRequest38(
            tabId = tab.id,
            url = tab.url
        )
    }
}
