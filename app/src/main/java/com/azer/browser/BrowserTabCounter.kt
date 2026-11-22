package com.azer.browser

object BrowserTabCounter {

    fun count(tabs: List<BrowserTab>): Int {
        return tabs.size
    }

    fun formatted(tabs: List<BrowserTab>): String {
        return tabs.size.toString()
    }

    fun canOpen(
        tabs: List<BrowserTab>
    ): Boolean {
        return tabs.size < BrowserTabLimits.MAX_TABS
    }
}
