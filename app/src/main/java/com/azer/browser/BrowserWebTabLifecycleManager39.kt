package com.azer.browser

class BrowserWebTabLifecycleManager39(
    private val registry: BrowserWebTabRegistry39
) {

    fun pauseTab(tabId: String): Boolean {
        val webView = registry.get(tabId) ?: return false

        BrowserWebTabLifecycle39.pause(webView)
        return true
    }

    fun resumeTab(tabId: String): Boolean {
        val webView = registry.get(tabId) ?: return false

        BrowserWebTabLifecycle39.resume(webView)
        return true
    }

    fun destroyTab(tabId: String): Boolean {
        val webView = registry.remove(tabId) ?: return false

        BrowserWebTabLifecycle39.destroy(webView)
        return true
    }

    fun pauseAll() {
        registry.getTabIds().forEach {
            pauseTab(it)
        }
    }

    fun resumeAll() {
        registry.getTabIds().forEach {
            resumeTab(it)
        }
    }
}
