package com.azer.browser

import android.webkit.WebView

class AzerWebViewEngineAdapter52(
    private val webView: WebView
) : BrowserEngineAdapter51 {

    override fun loadUrl(url: String) {
        webView.loadUrl(url)
    }

    override fun reload() {
        webView.reload()
    }

    override fun stopLoading() {
        webView.stopLoading()
    }

    override fun goBack(): Boolean {
        if (webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return false
    }

    override fun goForward(): Boolean {
        if (webView.canGoForward()) {
            webView.goForward()
            return true
        }
        return false
    }

    override fun currentUrl(): String? {
        return webView.url
    }

    override fun isLoading(): Boolean {
        return webView.progress < 100
    }
}
