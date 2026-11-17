
package com.azer.browser.vpn

class VpnServerRepository {

    private val servers = mutableListOf<VpnServer>()

    fun getAll(): List<VpnServer> {
        return servers.toList()
    }

    fun add(server: VpnServer) {
        servers.removeAll { it.id == server.id }
        servers.add(server)
    }

    fun find(id: String): VpnServer? {
        return servers.find { it.id == id }
    }

    fun remove(id: String) {
        servers.removeAll { it.id == id }
    }
}
