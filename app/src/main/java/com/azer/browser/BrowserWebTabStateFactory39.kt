package com.azer.browser

object BrowserWebTabStateFactory39 {

    fun create(tab: BrowserTab): BrowserWebTabState39 {
        return BrowserWebTabState39(
            tabId = tab.id,
            url = tab.url,
            title = tab.title
        )
    }

    fun createEmpty(tabId: String): BrowserWebTabState39 {
        return BrowserWebTabState39(
            tabId = tabId
        )
    }
}
