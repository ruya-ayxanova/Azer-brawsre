package com.azer.browser

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.webkit.CookieManager
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

        if (!DownloadPolicy.canDownload(context)) {
            Toast.makeText(
                context,
                "İndirme için Wi-Fi bağlantısı gerekli.",
                Toast.LENGTH_LONG
            ).show()
            return null
        }

        return try {

            val fileName = DownloadUtils.sanitizeFileName(
                android.webkit.URLUtil.guessFileName(
                    url,
                    contentDisposition,
                    mimeType
                )
            )

            val cookies = CookieManager.getInstance().getCookie(url)

            val manager = context.getSystemService(
                Context.DOWNLOAD_SERVICE
            ) as DownloadManager

            val request = DownloadManager.Request(
                Uri.parse(url)
            ).apply {

                setTitle(fileName)
                setDescription("Azer Browser indiriyor")
                setMimeType(mimeType)

                setNotificationVisibility(
                    if (DownloadSettings.getNotificationEnabled(context)) {
                        DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED
                    } else {
                        DownloadManager.Request.VISIBILITY_HIDDEN
                    }
                )

                if (userAgent.isNotBlank()) {
                    addRequestHeader("User-Agent", userAgent)
                }

                if (!cookies.isNullOrBlank()) {
                    addRequestHeader("Cookie", cookies)
                }

                setDestinationInExternalPublicDir(
                    Environment.DIRECTORY_DOWNLOADS,
                    "AzerBrowser/$fileName"
                )

                setAllowedOverMetered(true)
                setAllowedOverRoaming(false)
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
