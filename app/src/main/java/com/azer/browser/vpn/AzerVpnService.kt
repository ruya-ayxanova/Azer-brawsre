
package com.azer.browser.vpn

import android.net.VpnService
import android.content.Intent
import android.os.IBinder

class AzerVpnService : VpnService() {

    companion object {
        const val ACTION_START =
            "com.azer.browser.vpn.START"

        const val ACTION_STOP =
            "com.azer.browser.vpn.STOP"
    }

    override fun onStartCommand(
        intent: Intent?,
        flags: Int,
        startId: Int
    ): Int {

        when (intent?.action) {
            ACTION_STOP -> {
                stopForeground(true)
                stopSelf()
            }

            ACTION_START -> {
                // Gerçek VPN tüneli henüz eklenmedi.
                stopSelf()
            }
        }

        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return super.onBind(intent)
    }
}
