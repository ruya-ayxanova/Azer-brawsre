package com.azer.browser

object TabCommandValidator38 {

    fun isValid(
        action: TabMenuAction38,
        tabs: List<BrowserTab>
    ): Boolean {

        return tabs.any {
            it.id == action.tabId
        }
    }

    fun canDuplicate(
        tabs: List<BrowserTab>
    ): Boolean {
        return tabs.size < BrowserTabLimits.MAX_TABS
    }
}
