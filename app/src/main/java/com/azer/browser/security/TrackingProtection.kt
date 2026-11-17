
package com.azer.browser.security

class TrackingProtection {

    private val trackers = setOf(
        "google-analytics.com",
        "connect.facebook.net",
        "analytics.twitter.com",
        "hotjar.com",
        "segment.io"
    )

    fun shouldBlock(url: String): Boolean {
        val host = try {
            java.net.URI(url).host ?: return false
        } catch (e: Exception) {
            return false
        }

        return trackers.any {
            host == it || host.endsWith(".$it")
        }
    }
}
