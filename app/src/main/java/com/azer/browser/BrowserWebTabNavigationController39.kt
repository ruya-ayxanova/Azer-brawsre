package com.azer.browser

class BrowserWebTabNavigationController39(
    private val registry: BrowserWebTabRegistry39
) {

    fun load(
        tabId: String,
        url: String
    ): Boolean {
        val webView = registry.get(tabId) ?: return false

        return BrowserWebTabNavigation39.load(
            webView,
            url
        )
    }

    fun reload(tabId: String): Boolean {
        val webView = registry.get(tabId) ?: return false

        BrowserWebTabNavigation39.reload(webView)
        return true
    }

    fun back(tabId: String): Boolean {
        val webView = registry.get(tabId) ?: return false

        return BrowserWebTabNavigation39.goBack(webView)
    }

    fun forward(tabId: String): Boolean {
        val webView = registry.get(tabId) ?: return false

        return BrowserWebTabNavigation39.goForward(webView)
    }
}
