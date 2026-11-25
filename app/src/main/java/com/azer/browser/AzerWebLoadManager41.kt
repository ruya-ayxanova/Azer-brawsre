package com.azer.browser

import android.webkit.WebView

class AzerWebLoadManager41 {

    fun load(
        webView: WebView,
        input: String
    ): AzerNavigationResult41 {

        val request =
            AzerNavigationManager41().prepare(input)
                ?: return AzerNavigationResult41(
                    false,
                    input,
                    "Adres boş."
                )

        if (!AzerNavigationManager41().validate(request)) {
            return AzerNavigationResult41(
                false,
                request.url,
                "Adres geçersiz."
            )
        }

        webView.loadUrl(request.url)

        return AzerNavigationResult41(
            true,
            request.url,
            "Yükleme isteği gönderildi."
        )
    }

    fun reload(webView: WebView) {
        webView.reload()
    }

    fun stop(webView: WebView) {
        webView.stopLoading()
    }
}
