
package com.azer.browser.vpn

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

object VpnNotification {

    private const val CHANNEL_ID = "azer_vpn"

    fun create(
        context: Context,
        message: String
    ): Notification {

        val manager = context.getSystemService(
            Context.NOTIFICATION_SERVICE
        ) as NotificationManager

        if (Build.VERSION.SDK_INT >= 26) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Azer Browser VPN",
                NotificationManager.IMPORTANCE_LOW
            )

            manager.createNotificationChannel(channel)
        }

        return if (Build.VERSION.SDK_INT >= 26) {
            Notification.Builder(context, CHANNEL_ID)
                .setContentTitle("Azer Browser VPN")
                .setContentText(message)
                .setSmallIcon(
                    android.R.drawable.ic_lock_lock
                )
                .setOngoing(true)
                .build()
        } else {
            @Suppress("DEPRECATION")
            Notification.Builder(context)
                .setContentTitle("Azer Browser VPN")
                .setContentText(message)
                .setSmallIcon(
                    android.R.drawable.ic_lock_lock
                )
                .setOngoing(true)
                .build()
        }
    }
}
