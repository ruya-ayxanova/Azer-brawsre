
package com.azer.browser.download

import android.app.DownloadManager

class DownloadQuery(
    private val manager: DownloadManager
) {
    fun getStatus(id: Long): Int {
        val query = DownloadManager.Query().setFilterById(id)
        val cursor = manager.query(query)

        cursor.use {
            if (it != null && it.moveToFirst()) {
                return it.getInt(
                    it.getColumnIndexOrThrow(
                        DownloadManager.COLUMN_STATUS
                    )
                )
            }
        }
        return -1
    }
}
