package com.azer.browser

import android.content.Context
import android.app.DownloadManager

object DownloadQueryWorker {

    fun refresh(context: Context): List<DownloadItem> {

        val manager = context.getSystemService(
            Context.DOWNLOAD_SERVICE
        ) as DownloadManager

        val saved = DownloadRepository.getAll(context)
        val updated = mutableListOf<DownloadItem>()

        saved.forEach { item ->

            val cursor = manager.query(
                DownloadManager.Query().setFilterById(item.id)
            )

            cursor?.use {
                if (it.moveToFirst()) {

                    val status = when (
                        it.getInt(
                            it.getColumnIndexOrThrow(
                                DownloadManager.COLUMN_STATUS
                            )
                        )
                    ) {
                        DownloadManager.STATUS_PENDING ->
                            DownloadStatus.PENDING

                        DownloadManager.STATUS_RUNNING ->
                            DownloadStatus.RUNNING

                        DownloadManager.STATUS_PAUSED ->
                            DownloadStatus.PAUSED

                        DownloadManager.STATUS_SUCCESSFUL ->
                            DownloadStatus.COMPLETED

                        DownloadManager.STATUS_FAILED ->
                            DownloadStatus.FAILED

                        else -> DownloadStatus.PENDING
                    }

                    val downloaded = it.getLong(
                        it.getColumnIndexOrThrow(
                            DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR
                        )
                    )

                    val total = it.getLong(
                        it.getColumnIndexOrThrow(
                            DownloadManager.COLUMN_TOTAL_SIZE_BYTES
                        )
                    )

                    val progress = if (total > 0) {
                        ((downloaded * 100) / total).toInt()
                    } else 0

                    updated.add(
                        item.copy(
                            status = status,
                            downloadedBytes = downloaded,
                            totalBytes = total,
                            progress = progress.coerceIn(0, 100)
                        )
                    )
                }
            }
        }

        DownloadRepository.clear(context)
        updated.forEach {
            DownloadRepository.add(context, it)
        }

        return updated
    }
}
