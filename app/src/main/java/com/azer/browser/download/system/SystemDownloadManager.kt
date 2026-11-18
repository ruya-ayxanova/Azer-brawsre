package com.azer.browser.download.system

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.webkit.CookieManager

class SystemDownloadManager(context: Context) {

    private val appContext = context.applicationContext

    private val manager =
        appContext.getSystemService(Context.DOWNLOAD_SERVICE)
            as DownloadManager

    fun start(info: DownloadRequestInfo): DownloadResult {
        require(DownloadUrlValidator.isValid(info.url)) {
            "Geçersiz indirme adresi."
        }

        val fileName = DownloadFileName.create(
            info.url,
            info.contentDisposition,
            info.mimeType
        )

        val request = DownloadManager.Request(
            Uri.parse(info.url)
        )

        request.setTitle(fileName)
        request.setDescription("Azer Browser dosya indiriyor")
        request.setNotificationVisibility(
            DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED
        )

        request.setDestinationInExternalPublicDir(
            Environment.DIRECTORY_DOWNLOADS,
            fileName
        )

        request.setAllowedOverMetered(true)
        request.setAllowedOverRoaming(false)

        info.userAgent?.takeIf { it.isNotBlank() }?.let {
            request.addRequestHeader("User-Agent", it)
        }

        info.cookies?.takeIf { it.isNotBlank() }?.let {
            request.addRequestHeader("Cookie", it)
        }

        info.mimeType?.takeIf { it.isNotBlank() }?.let {
            request.setMimeType(it)
        }

        val id = manager.enqueue(request)

        return DownloadResult(
            downloadId = id,
            fileName = fileName,
            message = "İndirme başlatıldı."
        )
    }

    fun cancel(downloadId: Long): Int {
        return manager.remove(downloadId)
    }
}
