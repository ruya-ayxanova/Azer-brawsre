package com.azer.browser.ui.downloads

import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.widget.Toast

object DownloadOpenAction {

    fun open(context: Context, id: Long) {
        try {
            val manager = context.getSystemService(
                Context.DOWNLOAD_SERVICE
            ) as DownloadManager

            val uri = manager.getUriForDownloadedFile(id)

            if (uri == null) {
                Toast.makeText(
                    context,
                    "Dosya henüz hazır değil.",
                    Toast.LENGTH_SHORT
                ).show()
                return
            }

            val mimeType = manager.getMimeTypeForDownloadedFile(id)
                ?: "*/*"

            val intent = Intent(Intent.ACTION_VIEW).apply {
                setDataAndType(uri, mimeType)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }

            context.startActivity(
                Intent.createChooser(intent, "Dosyayı aç")
            )

        } catch (e: Exception) {
            Toast.makeText(
                context,
                "Dosya açılamadı.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
