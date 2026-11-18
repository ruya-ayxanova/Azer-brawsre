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
        try {
            if (!url.startsWith("http://") &&
                !url.startsWith("https://")) {
                Toast.makeText(
                    context,
                    "Desteklenmeyen indirme bağlantısı",
                    Toast.LENGTH_SHORT
                ).show()
                return
            }

            val fileName = DownloadUtils.getFileName(
                url,
                mimeType
            )

            val id = DownloadManagerHelper.enqueue(
                context,
                url,
                fileName,
                mimeType
            )

            Toast.makeText(
                context,
                "İndirme başlatıldı: $fileName",
                Toast.LENGTH_SHORT
            ).show()

        } catch (e: Exception) {
            Toast.makeText(
                context,
                "İndirme başlatılamadı: ${e.message}",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
