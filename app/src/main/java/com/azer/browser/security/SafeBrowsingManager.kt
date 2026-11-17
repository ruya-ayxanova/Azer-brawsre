
package com.azer.browser.security

import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.SafeBrowsingResponse
import android.webkit.WebResourceRequest

class SafeBrowsingManager {

    fun configure(webView: WebView) {
        WebView.startSafeBrowsing(
            webView.context
        ) { success ->
            // Android Safe Browsing initialization result
        }
    }

    fun createClient(): WebViewClient {
        return object : WebViewClient() {

            override fun onSafeBrowsingHit(
                view: WebView,
                request: WebResourceRequest,
                threatType: Int,
                callback: SafeBrowsingResponse
            ) {
                callback.backToSafety(true)
            }
        }
    }
}
