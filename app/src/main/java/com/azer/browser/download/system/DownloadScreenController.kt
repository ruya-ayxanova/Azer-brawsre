package com.azer.browser.download.system

import android.content.Context

class DownloadScreenController(context: Context) {

    private val reader = DownloadRecordReader(context)
    private val manager = SystemDownloadManager(context)

    fun getDownloads(): List<DownloadRecord> {
        return reader.readAll()
    }

    fun cancel(id: Long): Int {
        return manager.cancel(id)
    }
}
