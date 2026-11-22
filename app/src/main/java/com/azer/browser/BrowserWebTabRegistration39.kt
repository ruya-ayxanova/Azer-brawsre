package com.azer.browser

import android.webkit.WebView

class BrowserWebTabRegistration39(
    private val registry: BrowserWebTabRegistry39
) {

    fun register(
        tabId: String,
        webView: WebView
    ): Boolean {
        return registry.register(tabId, webView)
    }

    fun unregister(
        tabId: String
    ): WebView? {
        return registry.remove(tabId)
    }

    fun registered(
        tabId: String
    ): Boolean {
        return registry.contains(tabId)
    }
}
