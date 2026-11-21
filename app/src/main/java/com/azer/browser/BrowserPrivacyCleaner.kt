package com.azer.browser

import android.webkit.WebStorage
import android.webkit.WebView

class BrowserPrivacyCleaner {

    fun clearCookies(
        callback: ((Boolean) -> Unit)? = null
    ) {
        BrowserCookieManager.removeAllCookies(callback)
        BrowserCookieManager.flush()
    }

    fun clearWebStorage() {
        WebStorage.getInstance().deleteAllData()
    }

    fun clearCache(webView: WebView?) {
        webView?.clearCache(true)
    }

    fun clearFormData(webView: WebView?) {
        webView?.clearFormData()
    }

    fun clearHistory(webView: WebView?) {
        webView?.clearHistory()
    }

    fun clearAll(webView: WebView?) {
        clearCookies()
        clearWebStorage()
        clearCache(webView)
        clearFormData(webView)
        clearHistory(webView)
    }
}
