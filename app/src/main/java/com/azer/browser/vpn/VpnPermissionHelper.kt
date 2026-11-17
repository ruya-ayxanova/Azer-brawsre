
package com.azer.browser.vpn

import android.content.Context
import android.content.Intent
import android.net.VpnService

object VpnPermissionHelper {

    fun getPermissionIntent(
        context: Context
    ): Intent? {
        return VpnService.prepare(context)
    }

    fun hasPermission(context: Context): Boolean {
        return VpnService.prepare(context) == null
    }
}
