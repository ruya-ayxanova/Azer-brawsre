class AzerDownloadFileNameCleaner49 {

    fun clean(name: String): String {
        val cleaned = name
            .replace("/", "_")
            .replace("\\", "_")
            .replace(":", "_")
            .replace("*", "_")
            .replace("?", "_")
            .replace("\"", "_")
            .replace("<", "_")
            .replace(">", "_")
            .replace("|", "_")
            .trim()

        return cleaned.ifBlank { "download_file" }
    }
}
