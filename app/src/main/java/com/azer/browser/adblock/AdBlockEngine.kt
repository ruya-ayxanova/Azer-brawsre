
package com.azer.browser.adblock

class AdBlockEngine {

    private val blockedDomains = setOf(
        "doubleclick.net",
        "googlesyndication.com",
        "googleadservices.com",
        "adservice.google.com",
        "adnxs.com",
        "popads.net",
        "popcash.net",
        "adform.net",
        "taboola.com",
        "outbrain.com"
    )

    fun isBlocked(url: String): Boolean {
        val host = try {
            java.net.URI(url).host ?: return false
        } catch (e: Exception) {
            return false
        }

        return blockedDomains.any {
            host == it || host.endsWith(".$it")
        }
    }
}
