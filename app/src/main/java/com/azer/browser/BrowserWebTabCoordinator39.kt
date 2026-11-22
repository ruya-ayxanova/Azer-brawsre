package com.azer.browser

class BrowserWebTabCoordinator39(
    private val controller: BrowserWebTabController39,
    private val lifecycle: BrowserWebTabLifecycleManager39,
    private val navigation: BrowserWebTabNavigationController39
) {

    fun activate(tabId: String): Boolean {
        val webView = controller.getWebView(tabId)
            ?: return false

        lifecycle.resumeTab(tabId)

        webView.visibility =
            android.view.View.VISIBLE

        return true
    }

    fun pause(tabId: String): Boolean {
        return lifecycle.pauseTab(tabId)
    }

    fun load(
        tabId: String,
        url: String
    ): Boolean {
        return navigation.load(tabId, url)
    }

    fun close(tabId: String) {
        lifecycle.destroyTab(tabId)
        controller.remove(tabId)
    }
}
