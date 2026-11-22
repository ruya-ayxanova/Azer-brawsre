package com.azer.browser

import android.webkit.WebView

object BrowserWebTabLookup39 {

    fun find(
        registry: BrowserWebTabRegistry39,
        tabId: String
    ): WebView? {
        return registry.get(tabId)
    }

    fun exists(
        registry: BrowserWebTabRegistry39,
        tabId: String
    ): Boolean {
        return registry.contains(tabId)
    }
}
