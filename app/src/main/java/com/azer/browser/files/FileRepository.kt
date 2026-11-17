
package com.azer.browser.files

import android.os.Environment
import java.io.File

class FileRepository {

    fun getDownloads(): List<FileItem> {
        val directory =
            Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS
            )

        return directory.listFiles()?.map {
            FileItem(
                name = it.name,
                path = it.absolutePath,
                size = it.length(),
                isDirectory = it.isDirectory
            )
        } ?: emptyList()
    }
}
