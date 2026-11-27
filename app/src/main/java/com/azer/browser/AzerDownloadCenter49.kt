class AzerDownloadCenter49 {

    private val manager =
        AzerDownloadManager49()

    fun add(
        url: String,
        fileName: String,
        mimeType: String = ""
    ): AzerDownloadResult49 {

        val request = AzerDownloadRequest49(
            url = url,
            fileName = fileName,
            mimeType = mimeType
        )

        return manager.addDownload(request)
    }

    fun getAll(): List<AzerDownloadItem49> {
        return manager.getDownloads()
    }

    fun getQueue(): List<AzerDownloadItem49> {
        return manager.getQueue()
    }

    fun getHistory(): List<AzerDownloadItem49> {
        return manager.getHistory()
    }

    fun getById(id: String): AzerDownloadItem49? {
        return manager.getDownload(id)
    }

    fun remove(id: String) {
        manager.removeDownload(id)
    }

    fun clear() {
        manager.clearDownloads()
    }
}
