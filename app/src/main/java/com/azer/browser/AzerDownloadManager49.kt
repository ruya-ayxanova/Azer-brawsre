class AzerDownloadManager49 {

    private val validator =
        AzerDownloadValidator49()

    private val factory =
        AzerDownloadFactory49()

    private val queue =
        AzerDownloadQueue49()

    private val repository =
        AzerDownloadRepository49()

    private val history =
        AzerDownloadHistory49()

    fun addDownload(
        request: AzerDownloadRequest49
    ): AzerDownloadResult49 {

        if (!validator.isValidUrl(request.url)) {
            return AzerDownloadResult49(
                false,
                "",
                "Geçersiz indirme adresi"
            )
        }

        if (!validator.isValidFileName(request.fileName)) {
            return AzerDownloadResult49(
                false,
                "",
                "Geçersiz dosya adı"
            )
        }

        val item = factory.create(request)

        queue.add(item)
        repository.insert(item)

        return AzerDownloadResult49(
            true,
            item.id,
            "İndirme kuyruğa eklendi"
        )
    }

    fun getDownloads(): List<AzerDownloadItem49> {
        return repository.getAll()
    }

    fun getQueue(): List<AzerDownloadItem49> {
        return queue.getAll()
    }

    fun getHistory(): List<AzerDownloadItem49> {
        return history.getAll()
    }

    fun getDownload(id: String): AzerDownloadItem49? {
        return repository.get(id)
    }

    fun removeDownload(id: String) {
        queue.remove(id)
        repository.delete(id)
    }

    fun clearDownloads() {
        queue.clear()
        repository.clear()
        history.clear()
    }
}
