
package com.azer.browser

import android.webkit.WebView

class TabWebViewNavigator(
    private val repository: TabWebViewRepository
) {

    fun loadUrl(tabId: String, url: String) {
        if (url.isBlank()) return

        val webView = repository.find(tabId)
            ?: repository.getOrCreate(tabId)

        webView.loadUrl(url)
    }

    fun reload(tabId: String) {
        repository.find(tabId)?.reload()
    }

    fun goBack(tabId: String): Boolean {
        return repository.goBack(tabId)
    }

    fun goForward(tabId: String): Boolean {
        val webView = repository.find(tabId) ?: return false

        if (webView.canGoForward()) {
            webView.goForward()
            return true
        }

        return false
    }

    fun getCurrentUrl(tabId: String): String? {
        return repository.find(tabId)?.url
    }

    fun getWebView(tabId: String): WebView? {
        return repository.find(tabId)
    }
}
