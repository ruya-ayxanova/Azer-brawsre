package com.azer.browser

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment

object DownloadManagerHelper {

    fun enqueue(
        context: Context,
        url: String,
        title: String = "",
        mimeType: String? = null
    ): Long {
        val manager = context.getSystemService(
            Context.DOWNLOAD_SERVICE
        ) as DownloadManager

        val fileName = DownloadUtils.getFileName(url, mimeType)

        val request = DownloadManager.Request(Uri.parse(url)).apply {
            setTitle(title.ifBlank { fileName })
            setDescription("Azer Browser indiriyor...")
            setMimeType(mimeType)
            setNotificationVisibility(
                DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED
            )
            setDestinationInExternalPublicDir(
                Environment.DIRECTORY_DOWNLOADS,
                "AzerBrowser/$fileName"
            )
            setAllowedOverMetered(true)
            setAllowedOverRoaming(false)
        }

        return manager.enqueue(request)
    }

    fun query(context: Context, id: Long): DownloadItem? {
        val manager = context.getSystemService(
            Context.DOWNLOAD_SERVICE
        ) as DownloadManager

        val cursor = manager.query(
            DownloadManager.Query().setFilterById(id)
        ) ?: return null

        cursor.use {
            if (!it.moveToFirst()) return null

            val statusColumn = it.getColumnIndex(
                DownloadManager.COLUMN_STATUS
            )

            val reasonColumn = it.getColumnIndex(
                DownloadManager.COLUMN_REASON
            )

            val downloadedColumn = it.getColumnIndex(
                DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR
            )

            val totalColumn = it.getColumnIndex(
                DownloadManager.COLUMN_TOTAL_SIZE_BYTES
            )

            val uriColumn = it.getColumnIndex(
                DownloadManager.COLUMN_LOCAL_URI
            )

            val statusValue = it.getInt(statusColumn)
            val downloaded = it.getLong(downloadedColumn)
            val total = it.getLong(totalColumn)

            val progress = if (total > 0) {
                ((downloaded * 100) / total).toInt()
            } else {
                0
            }

            val status = when (statusValue) {
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

                else ->
                    DownloadStatus.PENDING
            }

            val fileUri = if (uriColumn >= 0) {
                it.getString(uriColumn) ?: ""
            } else {
                ""
            }

            val reason = if (reasonColumn >= 0) {
                it.getInt(reasonColumn)
            } else {
                0
            }

            return DownloadItem(
                id = id,
                title = "İndirme #$id",
                url = "",
                fileName = fileUri.substringAfterLast("/"),
                filePath = fileUri,
                status = status,
                progress = progress.coerceIn(0, 100),
                totalBytes = total,
                downloadedBytes = downloaded
            )
        }
    }

    fun cancel(context: Context, id: Long): Int {
        val manager = context.getSystemService(
            Context.DOWNLOAD_SERVICE
        ) as DownloadManager

        return manager.remove(id)
    }
}
