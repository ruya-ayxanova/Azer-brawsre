package com.azer.browser

import android.webkit.WebView

class BrowserWebTabRegistry39 {

    private val webViews =
        mutableMapOf<String, WebView>()

    fun register(
        tabId: String,
        webView: WebView
    ): Boolean {
        if (tabId.isBlank()) return false

        webViews[tabId] = webView
        return true
    }

    fun get(tabId: String): WebView? {
        return webViews[tabId]
    }

    fun remove(tabId: String): WebView? {
        return webViews.remove(tabId)
    }

    fun contains(tabId: String): Boolean {
        return webViews.containsKey(tabId)
    }

    fun count(): Int {
        return webViews.size
    }

    fun clear() {
        webViews.clear()
    }

    fun getTabIds(): List<String> {
        return webViews.keys.toList()
    }
}
