class AzerDownloadErrorManager49 {

    private val errors =
        mutableListOf<AzerDownloadError49>()

    fun add(error: AzerDownloadError49) {
        errors.add(error)
    }

    fun getAll(): List<AzerDownloadError49> {
        return errors.toList()
    }

    fun getForDownload(
        id: String
    ): List<AzerDownloadError49> {
        return errors.filter { it.downloadId == id }
    }

    fun clear() {
        errors.clear()
    }
}
