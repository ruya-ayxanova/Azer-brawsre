
package com.azer.browser.vpn

object VpnStatusFormatter {

    fun getText(state: VpnState): String {
        return when (state) {
            VpnState.DISCONNECTED -> "Bağlantı kesildi"
            VpnState.CONNECTING -> "Bağlanıyor..."
            VpnState.CONNECTED -> "Bağlandı"
            VpnState.DISCONNECTING -> "Bağlantı kesiliyor..."
            VpnState.ERROR -> "Bağlantı hatası"
        }
    }
}
