package com.azer.browser

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.app.DownloadManager

class DownloadBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(
        context: Context,
        intent: Intent
    ) {
        val id = intent.getLongExtra(
            DownloadManager.EXTRA_DOWNLOAD_ID,
            -1L
        )

        if (id == -1L) return

        val item = DownloadManagerHelper.query(context, id)
            ?: return

        DownloadRepository.update(
            context,
            item.copy(
                status = DownloadStatus.COMPLETED,
                progress = 100
            )
        )

        DownloadNotificationHelper.createChannel(context)
    }
}
