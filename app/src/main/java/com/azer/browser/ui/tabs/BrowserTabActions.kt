package com.azer.browser.ui.tabs

class BrowserTabActions(
    private val registry: BrowserTabRegistry
) {

    fun openTab(
        webView: android.webkit.WebView,
        url: String = "azer://home"
    ): Int {
        return registry.add(webView, url)
    }

    fun switchTab(index: Int): android.webkit.WebView? {
        return registry.activate(index)
    }

    fun closeTab(index: Int): android.webkit.WebView? {
        return registry.close(index)
    }

    fun tabCount(): Int {
        return registry.count
    }

    fun activeTab(): android.webkit.WebView? {
        return registry.getActive()
    }
}
