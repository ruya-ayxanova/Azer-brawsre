package com.azer.browser

import android.content.Context
import android.webkit.WebView

class BrowserPrivacyController(context: Context) {

    private val manager = BrowserPrivacyManager(context)
    private val cleaner = BrowserPrivacyCleaner()

    fun getSettings(): BrowserPrivacySettings {
        return manager.settings()
    }

    fun saveSettings(settings: BrowserPrivacySettings) {
        manager.save(settings)
    }

    fun applyToWebView(webView: WebView) {
        BrowserPrivacyWebViewConfig.apply(
            webView,
            manager.settings()
        )
    }

    fun clearCookies(
        callback: ((Boolean) -> Unit)? = null
    ) {
        cleaner.clearCookies(callback)
    }

    fun clearBrowsingData(webView: WebView?) {
        cleaner.clearAll(webView)
    }

    fun getStatus(url: String): BrowserPrivacyStatus {
        val settings = manager.settings()

        return BrowserPrivacyStatus(
            https = BrowserSecurityChecker.isHttps(url),
            cookiesEnabled = settings.cookiesEnabled,
            javascriptEnabled = settings.javascriptEnabled,
            trackingProtectionEnabled = settings.trackingProtection
        )
    }
}
