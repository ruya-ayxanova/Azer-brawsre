class AzerDownloadUpdater49 {

    fun updateProgress(
        item: AzerDownloadItem49,
        downloaded: Long,
        total: Long
    ): AzerDownloadItem49 {
        return item.copy(
            downloadedBytes = downloaded.coerceAtLeast(0L),
            totalBytes = total,
            status = AzerDownloadStatus49.IN_PROGRESS
        )
    }

    fun complete(
        item: AzerDownloadItem49
    ): AzerDownloadItem49 {
        return item.copy(
            status = AzerDownloadStatus49.COMPLETED
        )
    }

    fun fail(
        item: AzerDownloadItem49
    ): AzerDownloadItem49 {
        return item.copy(
            status = AzerDownloadStatus49.FAILED
        )
    }

    fun cancel(
        item: AzerDownloadItem49
    ): AzerDownloadItem49 {
        return item.copy(
            status = AzerDownloadStatus49.CANCELLED
        )
    }
}
