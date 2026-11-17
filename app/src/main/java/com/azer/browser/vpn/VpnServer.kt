
package com.azer.browser.vpn

data class VpnServer(
    val id: String,
    val name: String,
    val country: String,
    val host: String,
    val port: Int,
    val protocol: String
)
