package com.azer.browser

import android.webkit.WebResourceRequest

object BrowserTrackingRequestFilter {

    fun shouldBlock(
        request: WebResourceRequest,
        enabled: Boolean
    ): Boolean {
        if (!enabled) return false

        val url = request.url.toString()

        return BrowserTrackingProtection.isBlocked(url)
    }
}
