package com.azer.browser

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build

object DownloadReceiverRegistrar {

    fun register(
        context: Context,
        receiver: DownloadBroadcastReceiver
    ) {
        val filter = IntentFilter(
            android.app.DownloadManager.ACTION_DOWNLOAD_COMPLETE
        )

        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(
                receiver,
                filter,
                Context.RECEIVER_EXPORTED
            )
        } else {
            @Suppress("DEPRECATION")
            context.registerReceiver(receiver, filter)
        }
    }
}
