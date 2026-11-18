package com.azer.browser

import android.app.Activity
import android.content.Context
import android.view.View
import android.webkit.WebView
import android.widget.Toast

object DownloadIntegration {

    fun initialize(context: Context) {
        DownloadNotificationHelper.createChannel(context)
    }

    fun connectWebView(
        webView: WebView,
        context: Context
    ) {
        webView.setDownloadListener(
            BrowserDownloadListener(context)
        )
    }

    fun startDownload(
        context: Context,
        url: String,
        userAgent: String,
        contentDisposition: String,
        mimeType: String,
        contentLength: Long
    ): Long? {

        val id = DownloadRequestHandler.handle(
            context,
            url,
            userAgent,
            contentDisposition,
            mimeType,
            contentLength
        )

        if (id != null) {
            val fileName = DownloadUtils.getFileName(
                url,
                mimeType
            )

            DownloadRepository.add(
                context,
                DownloadItem(
                    id = id,
                    title = fileName,
                    url = url,
                    fileName = fileName,
                    status = DownloadStatus.PENDING
                )
            )
        }

        return id
    }

    fun openDownloads(activity: Activity) {
        activity.startActivity(
            android.content.Intent(
                activity,
                DownloadListActivity::class.java
            )
        )
    }

    fun openMenu(
        activity: Activity,
        anchor: View
    ) {
        DownloadMenuManager.show(activity, anchor)
    }

    fun refresh(context: Context) {
        DownloadQueryWorker.refresh(context)
    }
}
