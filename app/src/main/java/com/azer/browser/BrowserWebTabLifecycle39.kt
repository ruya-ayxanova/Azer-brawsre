package com.azer.browser

import android.webkit.WebView

object BrowserWebTabLifecycle39 {

    fun pause(webView: WebView) {
        webView.onPause()
        webView.pauseTimers()
    }

    fun resume(webView: WebView) {
        webView.onResume()
        webView.resumeTimers()
    }

    fun destroy(webView: WebView) {
        webView.stopLoading()
        webView.loadUrl("about:blank")
        webView.clearHistory()
        webView.removeAllViews()
        webView.destroy()
    }
}
