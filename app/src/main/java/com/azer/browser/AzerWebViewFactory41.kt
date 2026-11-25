package com.azer.browser

import android.content.Context
import android.webkit.WebView

object AzerWebViewFactory41 {

    fun create(
        context: Context,
        onStarted: (String) -> Unit = {},
        onFinished: (String) -> Unit = {},
        onProgress: (Int) -> Unit = {},
        onTitle: (String) -> Unit = {},
        onError: (String) -> Unit = {}
    ): WebView {

        val webView = WebView(context)

        AzerWebViewSettings41.configure(webView)

        webView.webViewClient = AzerWebViewClient41(
            onPageStartedCallback = onStarted,
            onPageFinishedCallback = onFinished,
            onErrorCallback = onError
        )

        webView.webChromeClient = AzerWebChromeClient41(
            onProgressChangedCallback = onProgress,
            onTitleChangedCallback = onTitle
        )

        return webView
    }
}
