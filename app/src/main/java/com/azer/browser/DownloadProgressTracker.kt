package com.azer.browser

import android.content.Context

object DownloadProgressTracker {

    fun update(context: Context): List<DownloadItem> {

        val saved = DownloadRepository.getAll(context)
        val updated = mutableListOf<DownloadItem>()

        saved.forEach { oldItem ->

            val current = DownloadManagerHelper.query(
                context,
                oldItem.id
            )

            if (current != null) {

                val item = current.copy(
                    title = oldItem.title,
                    url = oldItem.url,
                    fileName = oldItem.fileName,
                    createdAt = oldItem.createdAt
                )

                DownloadRepository.update(context, item)
                updated.add(item)

            } else {
                updated.add(oldItem)
            }
        }

        return updated
    }
}
