package com.azer.browser

object BrowserNetworkTypeResolver {

    fun resolve(state: BrowserNetworkState): BrowserNetworkType {
        if (!state.connected) return BrowserNetworkType.NONE

        return state.networkType
    }

    fun getName(type: BrowserNetworkType): String {
        return when (type) {
            BrowserNetworkType.WIFI -> "Wi-Fi"
            BrowserNetworkType.MOBILE -> "Mobil veri"
            BrowserNetworkType.ETHERNET -> "Ethernet"
            BrowserNetworkType.VPN -> "VPN"
            BrowserNetworkType.OTHER -> "Diğer ağ"
            BrowserNetworkType.NONE -> "Bağlantı yok"
        }
    }
}
