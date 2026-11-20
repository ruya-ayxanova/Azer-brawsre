
package com.azer.browser

import java.util.UUID

class BookmarkFolderRepository(
    private val storage: BookmarkStorage
) {

    companion object {
        const val DEFAULT_FOLDER_ID = "azer_default_folder"
    }

    fun getAll(): List<BookmarkFolder> {
        val folders = BookmarkJsonCodec.decodeFolders(
            storage.readFolders()
        )

        if (folders.none { it.id == DEFAULT_FOLDER_ID }) {
            val defaultFolder = BookmarkFolder(
                DEFAULT_FOLDER_ID,
                "Genel"
            )

            save(folders + defaultFolder)
            return folders + defaultFolder
        }

        return folders
    }

    fun add(name: String): BookmarkFolder? {
        val cleanName = name.trim()

        if (cleanName.isEmpty()) return null

        val folders = getAll()

        if (folders.any {
            it.name.equals(cleanName, ignoreCase = true)
        }) {
            return null
        }

        val folder = BookmarkFolder(
            UUID.randomUUID().toString(),
            cleanName
        )

        save(folders + folder)
        return folder
    }

    fun rename(id: String, name: String): Boolean {
        val cleanName = name.trim()
        if (cleanName.isEmpty() || id == DEFAULT_FOLDER_ID) {
            return false
        }

        val folders = getAll()

        if (folders.any {
            it.id != id &&
                it.name.equals(cleanName, ignoreCase = true)
        }) {
            return false
        }

        val folder = folders.find { it.id == id } ?: return false
        folder.name = cleanName

        save(folders)
        return true
    }

    fun delete(id: String): Boolean {
        if (id == DEFAULT_FOLDER_ID) return false

        val folders = getAll()
        val updated = folders.filterNot { it.id == id }

        if (updated.size == folders.size) return false

        save(updated)
        return true
    }

    private fun save(folders: List<BookmarkFolder>) {
        storage.writeFolders(
            BookmarkJsonCodec.encodeFolders(folders)
        )
    }
}
