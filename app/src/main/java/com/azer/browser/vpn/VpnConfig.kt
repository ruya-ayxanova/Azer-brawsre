
package com.azer.browser.vpn

data class VpnConfig(
    val serverId: String,
    val autoConnect: Boolean = false,
    val blockWithoutVpn: Boolean = false
)
