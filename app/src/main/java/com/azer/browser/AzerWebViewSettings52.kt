package com.azer.browser

import android.webkit.WebView

object AzerWebViewSettings52 {

    fun apply(webView: WebView) {
        val settings = webView.settings

        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        settings.loadsImagesAutomatically = true
        settings.javaScriptCanOpenWindowsAutomatically = false

        settings.allowFileAccess = false
        settings.allowContentAccess = true

        settings.setSupportZoom(true)
        settings.builtInZoomControls = true
        settings.displayZoomControls = false

        settings.useWideViewPort = true
        settings.loadWithOverviewMode = true
    }
}
