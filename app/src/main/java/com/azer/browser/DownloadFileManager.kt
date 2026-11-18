package com.azer.browser

import android.content.Context
import android.net.Uri
import android.app.DownloadManager

object DownloadFileManager {

    fun getDownloadedUri(
        context: Context,
        id: Long
    ): Uri? {
        return try {
            val manager = context.getSystemService(
                Context.DOWNLOAD_SERVICE
            ) as DownloadManager

            manager.getUriForDownloadedFile(id)
        } catch (_: Exception) {
            null
        }
    }

    fun exists(
        context: Context,
        id: Long
    ): Boolean {
        return getDownloadedUri(context, id) != null
    }

    fun getMimeType(
        context: Context,
        uri: Uri
    ): String {
        return context.contentResolver.getType(uri) ?: "*/*"
    }
}
