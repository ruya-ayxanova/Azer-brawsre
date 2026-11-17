package com.azer.browser.media

import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.WebResourceRequest

class MediaDetectionClient(
    private val onMediaFound: (MediaItem) -> Unit
) : WebViewClient() {

    override fun shouldInterceptRequest(
        view: WebView?,
        request: WebResourceRequest?
    ): android.webkit.WebResourceResponse? {

        val url = request?.url?.toString()
            ?: return null

        val type = MediaDetector.detect(url)

        if (type != MediaType.UNKNOWN) {
            onMediaFound(
                MediaItem(
                    url = url,
                    title = request.url.lastPathSegment
                        ?: "Medya dosyası",
                    type = type
                )
            )
        }

        return null
    }
}
