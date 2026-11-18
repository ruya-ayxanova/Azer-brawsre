package com.azer.browser

import android.content.Context
import android.webkit.DownloadListener
import android.widget.Toast

class BrowserDownloadListener(
    private val context: Context
) : DownloadListener {

    override fun onDownloadStart(
        url: String,
        userAgent: String,
        contentDisposition: String,
        mimeType: String,
        contentLength: Long
    ) {

        val id = DownloadIntegration.startDownload(
            context,
            url,
            userAgent,
            contentDisposition,
            mimeType,
            contentLength
        )

        if (id != null) {
            Toast.makeText(
                context,
                "İndirme başlatıldı",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
