
package com.azer.browser.privacy

import android.webkit.WebView
import android.webkit.WebSettings

class PrivateModeController {

    fun configure(webView: WebView) {
        webView.settings.apply {
            cacheMode = WebSettings.LOAD_NO_CACHE
            saveFormData = false
            javaScriptEnabled = true
            domStorageEnabled = false
            databaseEnabled = false
        }
    }

    fun clearTemporaryData(webView: WebView) {
        webView.clearHistory()
        webView.clearCache(true)
        webView.clearFormData()
    }
}
