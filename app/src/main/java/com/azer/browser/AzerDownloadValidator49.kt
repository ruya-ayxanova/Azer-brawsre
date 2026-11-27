class AzerDownloadValidator49 {

    fun isValidUrl(url: String): Boolean {
        return url.startsWith("https://", true) ||
                url.startsWith("http://", true)
    }

    fun isValidFileName(name: String): Boolean {
        return name.isNotBlank() &&
                !name.contains("/") &&
                !name.contains("\\")
    }

    fun isValidSize(size: Long): Boolean {
        return size >= -1L
    }
}
