
package com.azer.browser.download

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.webkit.URLUtil

class DownloadRepository(context: Context) {

    private val manager =
        context.getSystemService(Context.DOWNLOAD_SERVICE)
                as DownloadManager

    fun download(url: String, userAgent: String): Long {
        val fileName = URLUtil.guessFileName(
            url, null, null
        )

        val request = DownloadManager.Request(Uri.parse(url))
        request.setTitle(fileName)
        request.setDescription("Azer Browser indiriyor")
        request.addRequestHeader("User-Agent", userAgent)
        request.setNotificationVisibility(
            DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED
        )
        request.setDestinationInExternalPublicDir(
            Environment.DIRECTORY_DOWNLOADS,
            fileName
        )

        return manager.enqueue(request)
    }
}
