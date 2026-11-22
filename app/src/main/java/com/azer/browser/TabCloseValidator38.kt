package com.azer.browser

object TabCloseValidator38 {

    fun validate(
        request: TabCloseRequest38,
        tabs: List<BrowserTab>
    ): Boolean {
        if (request.tabId.isBlank()) return false

        return tabs.any {
            it.id == request.tabId
        }
    }
}
