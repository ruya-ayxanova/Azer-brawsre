data class AzerDownloadItem49(
    val id: String,
    val url: String,
    val fileName: String,
    val mimeType: String = "",
    val totalBytes: Long = -1L,
    val downloadedBytes: Long = 0L,
    val status: AzerDownloadStatus49 =
        AzerDownloadStatus49.PENDING,
    val createdAt: Long = System.currentTimeMillis()
)
