
package com.azer.browser

import android.webkit.WebView

object TabWebViewLifecycle {

    fun pause(webView: WebView?) {
        webView?.onPause()
    }

    fun resume(webView: WebView?) {
        webView?.onResume()
    }

    fun stop(webView: WebView?) {
        webView?.stopLoading()
    }

    fun clear(webView: WebView?) {
        webView?.apply {
            stopLoading()
            loadUrl("about:blank")
            clearHistory()
            removeAllViews()
            destroy()
        }
    }
}
