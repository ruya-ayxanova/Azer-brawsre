package com.azer.browser

object BrowserTabUpdater {

    fun updateTitle(
        tab: BrowserTab,
        title: String
    ) {
        if (title.isNotBlank()) {
            tab.title = title
        }
    }

    fun updateUrl(
        tab: BrowserTab,
        url: String
    ) {
        if (BrowserTabValidator.isValidUrl(url)) {
            tab.url = url
            tab.lastAccessedAt = System.currentTimeMillis()
        }
    }

    fun setLoading(
        tab: BrowserTab,
        loading: Boolean
    ) {
        tab.isLoading = loading
    }
}
