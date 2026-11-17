
package com.azer.browser.vpn

import android.content.Context
import android.content.Intent

class VpnController(
    private val context: Context
) {

    fun permissionIntent(): Intent? {
        return VpnPermissionHelper
            .getPermissionIntent(context)
    }

    fun hasPermission(): Boolean {
        return VpnPermissionHelper
            .hasPermission(context)
    }

    fun stop() {
        val intent = Intent(
            context,
            AzerVpnService::class.java
        ).apply {
            action = AzerVpnService.ACTION_STOP
        }

        context.startService(intent)
    }
}
