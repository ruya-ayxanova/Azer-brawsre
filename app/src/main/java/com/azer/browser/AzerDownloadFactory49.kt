class AzerDownloadFactory49 {

    private val idGenerator =
        AzerDownloadIdGenerator49()

    fun create(
        request: AzerDownloadRequest49
    ): AzerDownloadItem49 {
        return AzerDownloadItem49(
            id = idGenerator.generate(),
            url = request.url,
            fileName = request.fileName,
            mimeType = request.mimeType
        )
    }
}
