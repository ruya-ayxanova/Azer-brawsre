package com.azer.browser

import android.content.Context
import android.webkit.CookieManager
import android.webkit.URLUtil
import android.widget.Toast

object DownloadRequestHandler {

    fun handle(
        context: Context,
        url: String,
        userAgent: String,
        contentDisposition: String,
        mimeType: String,
        contentLength: Long
    ): Long? {

        if (!url.startsWith("http://") &&
            !url.startsWith("https://")) {
            return null
        }

        return try {
            val cookies = CookieManager.getInstance()
                .getCookie(url)

            val fileName = URLUtil.guessFileName(
                url,
                contentDisposition,
                mimeType
            )

            val manager = context.getSystemService(
                Context.DOWNLOAD_SERVICE
            ) as android.app.DownloadManager

            val request = android.app.DownloadManager.Request(
                android.net.Uri.parse(url)
            ).apply {
                setTitle(fileName)
                setDescription("Azer Browser indiriyor")
                setMimeType(mimeType)
                setNotificationVisibility(
                    android.app.DownloadManager.Request
                        .VISIBILITY_VISIBLE_NOTIFY_COMPLETED
                )

                if (!userAgent.isNullOrBlank()) {
                    addRequestHeader("User-Agent", userAgent)
                }

                if (!cookies.isNullOrBlank()) {
                    addRequestHeader("Cookie", cookies)
                }

                setDestinationInExternalPublicDir(
                    android.os.Environment.DIRECTORY_DOWNLOADS,
                    "AzerBrowser/$fileName"
                )
            }

            manager.enqueue(request)

        } catch (e: Exception) {
            Toast.makeText(
                context,
                "İndirme hatası: ${e.message}",
                Toast.LENGTH_LONG
            ).show()

            null
        }
    }
}
