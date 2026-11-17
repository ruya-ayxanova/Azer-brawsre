
package com.azer.browser.security

import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.WebResourceRequest
import com.azer.browser.adblock.AdBlockEngine
import com.azer.browser.adblock.BlockedRequestCounter

class WebSecurityClient(
    private val adBlock: AdBlockEngine,
    private val counter: BlockedRequestCounter,
    private val tracking: TrackingProtection
) : WebViewClient() {

    override fun shouldInterceptRequest(
        view: WebView?,
        request: WebResourceRequest?
    ): android.webkit.WebResourceResponse? {

        val url = request?.url?.toString()
            ?: return null

        if (adBlock.isBlocked(url) ||
            tracking.shouldBlock(url)) {

            counter.addBlockedRequest()

            return android.webkit.WebResourceResponse(
                "text/plain",
                "UTF-8",
                204,
                "No Content",
                emptyMap(),
                java.io.ByteArrayInputStream(byteArrayOf())
            )
        }

        return super.shouldInterceptRequest(view, request)
    }
}
