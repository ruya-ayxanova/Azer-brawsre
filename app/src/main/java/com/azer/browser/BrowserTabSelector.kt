package com.azer.browser

object BrowserTabSelector {

    fun select(
        tabs: List<BrowserTab>,
        id: String
    ): BrowserTab? {
        return tabs.find { it.id == id }
    }

    fun first(tabs: List<BrowserTab>): BrowserTab? {
        return tabs.firstOrNull()
    }

    fun last(tabs: List<BrowserTab>): BrowserTab? {
        return tabs.lastOrNull()
    }

    fun active(tabs: List<BrowserTab>): BrowserTab? {
        return tabs.find { it.isActive }
    }
}
