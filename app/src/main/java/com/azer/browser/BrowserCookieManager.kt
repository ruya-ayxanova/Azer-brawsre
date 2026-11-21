package com.azer.browser

import android.webkit.CookieManager

object BrowserCookieManager {

    fun setCookiesEnabled(enabled: Boolean) {
        CookieManager.getInstance().setAcceptCookie(enabled)
    }

    fun setThirdPartyCookies(
        webView: android.webkit.WebView,
        enabled: Boolean
    ) {
        CookieManager.getInstance()
            .setAcceptThirdPartyCookies(webView, enabled)
    }

    fun flush() {
        CookieManager.getInstance().flush()
    }

    fun removeAllCookies(
        callback: ((Boolean) -> Unit)? = null
    ) {
        CookieManager.getInstance().removeAllCookies(callback)
    }

    fun removeSessionCookies(
        callback: ((Boolean) -> Unit)? = null
    ) {
        CookieManager.getInstance().removeSessionCookies(callback)
    }
}
