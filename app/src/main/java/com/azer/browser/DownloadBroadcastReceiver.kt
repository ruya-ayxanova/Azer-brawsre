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

        if (intent.action != DownloadManager.ACTION_DOWNLOAD_COMPLETE) {
            return
        }

        val id = intent.getLongExtra(
            DownloadManager.EXTRA_DOWNLOAD_ID,
            -1L
        )

        if (id == -1L) return

        val result = DownloadManagerHelper.query(context, id)
            ?: return

        val previous = DownloadRepository.find(context, id)

        val updated = result.copy(
            title = previous?.title ?: result.title,
            url = previous?.url ?: result.url,
            fileName = previous?.fileName ?: result.fileName,
            status = result.status
        )

        DownloadRepository.update(context, updated)
    }
}
