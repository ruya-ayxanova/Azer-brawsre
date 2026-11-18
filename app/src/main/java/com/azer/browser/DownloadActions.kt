package com.azer.browser

import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.widget.Toast

object DownloadActions {

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

            val mimeType = context.contentResolver.getType(uri)
                ?: "*/*"

            val intent = Intent(Intent.ACTION_VIEW).apply {
                setDataAndType(uri, mimeType)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }

            context.startActivity(
                Intent.createChooser(intent, "Dosyayı aç")
            )

        } catch (_: Exception) {
            Toast.makeText(
                context,
                "Dosya açılacak uygulama bulunamadı.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun share(context: Context, id: Long) {
        try {
            val manager = context.getSystemService(
                Context.DOWNLOAD_SERVICE
            ) as DownloadManager

            val uri = manager.getUriForDownloadedFile(id)

            if (uri == null) {
                Toast.makeText(
                    context,
                    "Dosya paylaşılmaya hazır değil.",
                    Toast.LENGTH_SHORT
                ).show()
                return
            }

            val intent = Intent(Intent.ACTION_SEND).apply {
                type = context.contentResolver.getType(uri) ?: "*/*"
                putExtra(Intent.EXTRA_STREAM, uri)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }

            context.startActivity(
                Intent.createChooser(intent, "Dosyayı paylaş")
            )

        } catch (_: Exception) {
            Toast.makeText(
                context,
                "Paylaşma işlemi başarısız.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun delete(context: Context, id: Long) {
        val manager = context.getSystemService(
            Context.DOWNLOAD_SERVICE
        ) as DownloadManager

        manager.remove(id)
        DownloadRepository.remove(context, id)

        Toast.makeText(
            context,
            "İndirme silindi",
            Toast.LENGTH_SHORT
        ).show()
    }

    fun cancel(context: Context, id: Long) {
        DownloadManagerHelper.cancel(context, id)
        DownloadRepository.remove(context, id)

        Toast.makeText(
            context,
            "İndirme iptal edildi",
            Toast.LENGTH_SHORT
        ).show()
    }
}
