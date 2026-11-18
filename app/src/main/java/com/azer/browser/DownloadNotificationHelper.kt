package com.azer.browser

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

object DownloadNotificationHelper {

    const val CHANNEL_ID = "azer_downloads"

    fun createChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Azer Browser İndirmeleri",
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = "İndirme bildirimleri"
            }

            val manager = context.getSystemService(
                NotificationManager::class.java
            )

            manager.createNotificationChannel(channel)
        }
    }

    fun cancelAll(context: Context) {
        val manager = context.getSystemService(
            Context.NOTIFICATION_SERVICE
        ) as NotificationManager

        manager.cancelAll()
    }
}
