package com.azer.browser.download.system

import android.app.DownloadManager
import android.content.Context

class DownloadQuery(context: Context) {

    private val manager =
        context.applicationContext.getSystemService(
            Context.DOWNLOAD_SERVICE
        ) as DownloadManager

    fun getState(downloadId: Long): DownloadState {
        val query = DownloadManager.Query()
            .setFilterById(downloadId)

        manager.query(query)?.use { cursor ->
            if (!cursor.moveToFirst()) {
                return DownloadState.UNKNOWN
            }

            return when (
                cursor.getInt(
                    cursor.getColumnIndexOrThrow(
                        DownloadManager.COLUMN_STATUS
                    )
                )
            ) {
                DownloadManager.STATUS_PENDING ->
                    DownloadState.PENDING

                DownloadManager.STATUS_RUNNING ->
                    DownloadState.RUNNING

                DownloadManager.STATUS_PAUSED ->
                    DownloadState.PAUSED

                DownloadManager.STATUS_SUCCESSFUL ->
                    DownloadState.SUCCESSFUL

                DownloadManager.STATUS_FAILED ->
                    DownloadState.FAILED

                else -> DownloadState.UNKNOWN
            }
        }

        return DownloadState.UNKNOWN
    }
}
