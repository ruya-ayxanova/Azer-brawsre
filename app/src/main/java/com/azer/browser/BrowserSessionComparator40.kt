package com.azer.browser

object BrowserSessionComparator40 {

    fun sameTabs(
        first: BrowserSession40,
        second: BrowserSession40
    ): Boolean {
        return first.tabIds == second.tabIds
    }

    fun sameActiveTab(
        first: BrowserSession40,
        second: BrowserSession40
    ): Boolean {
        return first.activeTabId == second.activeTabId
    }

    fun isDifferent(
        first: BrowserSession40,
        second: BrowserSession40
    ): Boolean {
        return first != second
    }
}
