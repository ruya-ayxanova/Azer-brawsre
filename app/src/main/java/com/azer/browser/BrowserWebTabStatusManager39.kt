package com.azer.browser

class BrowserWebTabStatusManager39 {

    private val statuses =
        mutableMapOf<String, BrowserWebTabStatus39>()

    fun set(
        tabId: String,
        status: BrowserWebTabStatus39
    ) {
        if (tabId.isNotBlank()) {
            statuses[tabId] = status
        }
    }

    fun get(
        tabId: String
    ): BrowserWebTabStatus39 {
        return statuses[tabId]
            ?: BrowserWebTabStatus39.CREATED
    }

    fun remove(tabId: String) {
        statuses.remove(tabId)
    }

    fun isLoading(tabId: String): Boolean {
        return get(tabId) ==
            BrowserWebTabStatus39.LOADING
    }

    fun clear() {
        statuses.clear()
    }
}
