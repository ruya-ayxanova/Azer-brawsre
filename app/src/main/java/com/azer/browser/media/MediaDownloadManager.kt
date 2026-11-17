
package com.azer.browser.media

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.webkit.URLUtil

class MediaDownloadManager(context: Context) {

    private val manager =
        context.getSystemService(
            Context.DOWNLOAD_SERVICE
        ) as DownloadManager

    fun download(
        url: String,
        title: String,
        userAgent: String = ""
    ): Long? {

        if (!MediaUrlValidator.isValid(url)) {
            return null
        }

        val fileName = URLUtil.guessFileName(
            url,
            null,
            null
        )

        val request = DownloadManager.Request(
            Uri.parse(url)
        )

        request.setTitle(title.ifBlank { fileName })
        request.setDescription("Azer Browser medya indiriyor")
        request.setNotificationVisibility(
            DownloadManager.Request
                .VISIBILITY_VISIBLE_NOTIFY_COMPLETED
        )

        if (userAgent.isNotBlank()) {
            request.addRequestHeader("User-Agent", userAgent)
        }

        request.setDestinationInExternalPublicDir(
            Environment.DIRECTORY_DOWNLOADS,
            fileName
        )

        return manager.enqueue(request)
    }
}
