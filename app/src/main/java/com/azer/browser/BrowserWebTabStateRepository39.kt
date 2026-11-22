package com.azer.browser

class BrowserWebTabStateRepository39 {

    private val states =
        mutableMapOf<String, BrowserWebTabState39>()

    fun put(state: BrowserWebTabState39) {
        states[state.tabId] = state
    }

    fun get(tabId: String): BrowserWebTabState39? {
        return states[tabId]
    }

    fun remove(tabId: String): BrowserWebTabState39? {
        return states.remove(tabId)
    }

    fun getAll(): List<BrowserWebTabState39> {
        return states.values.toList()
    }

    fun updateUrl(
        tabId: String,
        url: String
    ) {
        states[tabId]?.url = url
    }

    fun updateTitle(
        tabId: String,
        title: String
    ) {
        if (title.isNotBlank()) {
            states[tabId]?.title = title
        }
    }

    fun updateProgress(
        tabId: String,
        progress: Int
    ) {
        states[tabId]?.progress =
            progress.coerceIn(0, 100)
    }

    fun clear() {
        states.clear()
    }
}
