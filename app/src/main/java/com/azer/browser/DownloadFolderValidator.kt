package com.azer.browser

object DownloadFolderValidator {

    fun validate(folder: String): Boolean {

        if (folder.isBlank()) return false

        if (folder.startsWith("/")) return false

        if (folder.contains("..")) return false

        if (folder.contains(":")) return false

        if (folder.contains("\\")) return false

        return true
    }

    fun clean(folder: String): String {
        return folder.trim()
            .replace(Regex("[^a-zA-Z0-9_/-]"), "_")
            .trim('/')
    }
}
