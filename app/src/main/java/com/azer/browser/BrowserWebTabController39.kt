package com.azer.browser

class BrowserWebTabController39(
    private val registry: BrowserWebTabRegistry39,
    private val states: BrowserWebTabStateRepository39,
    private val statusManager: BrowserWebTabStatusManager39
) {

    fun register(
        tab: BrowserTab,
        webView: android.webkit.WebView
    ): Boolean {

        if (!registry.register(tab.id, webView)) {
            return false
        }

        states.put(
            BrowserWebTabStateFactory39.create(tab)
        )

        statusManager.set(
            tab.id,
            BrowserWebTabStatus39.CREATED
        )

        return true
    }

    fun getWebView(tabId: String): android.webkit.WebView? {
        return registry.get(tabId)
    }

    fun getState(tabId: String): BrowserWebTabState39? {
        return states.get(tabId)
    }

    fun remove(tabId: String) {
        registry.remove(tabId)
        states.remove(tabId)
        statusManager.remove(tabId)
    }

    fun tabCount(): Int {
        return registry.count()
    }
}
