package com.azer.browser.download.system

import android.app.DownloadManager
import android.content.Context

class DownloadRecordReader(context: Context) {

    private val manager =
        context.applicationContext.getSystemService(
            Context.DOWNLOAD_SERVICE
        ) as DownloadManager

    fun readAll(): List<DownloadRecord> {
        val records = mutableListOf<DownloadRecord>()

        manager.query(DownloadManager.Query())?.use { cursor ->

            while (cursor.moveToNext()) {

                val id = cursor.getLong(
                    cursor.getColumnIndexOrThrow(
                        DownloadManager.COLUMN_ID
                    )
                )

                val title = cursor.getString(
                    cursor.getColumnIndexOrThrow(
                        DownloadManager.COLUMN_TITLE
                    )
                ) ?: "Bilinmeyen dosya"

                val statusCode = cursor.getInt(
                    cursor.getColumnIndexOrThrow(
                        DownloadManager.COLUMN_STATUS
                    )
                )

                val downloaded = cursor.getLong(
                    cursor.getColumnIndexOrThrow(
                        DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR
                    )
                )

                val total = cursor.getLong(
                    cursor.getColumnIndexOrThrow(
                        DownloadManager.COLUMN_TOTAL_SIZE_BYTES
                    )
                )

                val state = when (statusCode) {
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

                records.add(
                    DownloadRecord(
                        id = id,
                        fileName = title,
                        status = state,
                        downloadedBytes = downloaded,
                        totalBytes = total
                    )
                )
            }
        }

        return records
    }
}
