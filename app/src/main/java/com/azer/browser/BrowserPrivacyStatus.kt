package com.azer.browser

data class BrowserPrivacyStatus(
    val https: Boolean,
    val cookiesEnabled: Boolean,
    val javascriptEnabled: Boolean,
    val trackingProtectionEnabled: Boolean
) {
    fun summary(): String {
        return buildList {
            add(if (https) "HTTPS bağlantı" else "HTTP bağlantı")
            add(if (cookiesEnabled) "Çerezler açık" else "Çerezler kapalı")
            add(if (javascriptEnabled) "JavaScript açık" else "JavaScript kapalı")
            add(
                if (trackingProtectionEnabled)
                    "Takip koruması açık"
                else
                    "Takip koruması kapalı"
            )
        }.joinToString("\n")
    }
}
