
package com.azer.browser.vpn

import android.content.Context

class VpnSettings(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_vpn_settings",
        Context.MODE_PRIVATE
    )

    var autoConnect: Boolean
        get() = prefs.getBoolean("auto_connect", false)
        set(value) {
            prefs.edit()
                .putBoolean("auto_connect", value)
                .apply()
        }

    var blockWithoutVpn: Boolean
        get() = prefs.getBoolean("block_without_vpn", false)
        set(value) {
            prefs.edit()
                .putBoolean("block_without_vpn", value)
                .apply()
        }

    var selectedServer: String
        get() = prefs.getString("selected_server", "") ?: ""
        set(value) {
            prefs.edit()
                .putString("selected_server", value)
                .apply()
        }
}
