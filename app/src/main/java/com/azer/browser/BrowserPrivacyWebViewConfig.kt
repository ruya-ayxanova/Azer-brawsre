package com.azer.browser

import android.webkit.WebView

object BrowserPrivacyWebViewConfig {

    fun apply(
        webView: WebView,
        settings: BrowserPrivacySettings
    ) {
        webView.settings.apply {
            javaScriptEnabled = settings.javascriptEnabled
            domStorageEnabled = true
        }

        BrowserCookieManager.setCookiesEnabled(
            settings.cookiesEnabled
        )

        BrowserCookieManager.setThirdPartyCookies(
            webView,
            !settings.blockThirdPartyCookies
        )
    }
}
