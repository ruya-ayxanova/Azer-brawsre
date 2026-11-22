package com.azer.browser

object BrowserNetworkFormatter {

    fun connectionText(state: BrowserNetworkState): String {
        return when {
            !state.connected -> "İnternet bağlantısı yok"
            !state.internetAvailable -> "İnternet erişimi doğrulanamadı"
            else -> "İnternet bağlantısı var"
        }
    }

    fun typeText(state: BrowserNetworkState): String {
        return BrowserNetworkTypeResolver.getName(state.networkType)
    }

    fun qualityText(
        quality: BrowserConnectionQuality
    ): String {
        return when (quality) {
            BrowserConnectionQuality.OFFLINE -> "Çevrimdışı"
            BrowserConnectionQuality.WEAK -> "Zayıf bağlantı"
            BrowserConnectionQuality.NORMAL -> "Normal bağlantı"
            BrowserConnectionQuality.GOOD -> "İyi bağlantı"
            BrowserConnectionQuality.UNKNOWN -> "Bilinmiyor"
        }
    }
}
