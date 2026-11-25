package com.azer.browser

import android.webkit.WebView

class AzerAddressNavigation42 {

    private val resolver =
        AzerInputResolver42()

    fun navigate(
        webView: WebView,
        input: String
    ): Boolean {

        val target = resolver.resolve(input)

        if (target.isBlank()) return false

        webView.loadUrl(target)
        return true
    }
}
