package com.azer.browser

object BrowserTrackingProtection {

    private val blockedDomains = setOf(
        "doubleclick.net",
        "googlesyndication.com",
        "google-analytics.com",
        "googletagmanager.com",
        "facebook.net",
        "connect.facebook.net",
        "adservice.google.com",
        "scorecardresearch.com",
        "ads.yahoo.com"
    )

    fun isBlocked(url: String): Boolean {
        val host = try {
            java.net.URI(url).host?.lowercase() ?: return false
        } catch (_: Exception) {
            return false
        }

        return blockedDomains.any {
            host == it || host.endsWith(".$it")
        }
    }

    fun blockedList(): List<String> {
        return blockedDomains.toList()
    }
}
