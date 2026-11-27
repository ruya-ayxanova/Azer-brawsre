class AzerDownloadProgressCalculator49 {

    fun calculate(
        downloaded: Long,
        total: Long
    ): Int {
        if (total <= 0L) return 0

        val safeDownloaded = downloaded.coerceAtLeast(0L)

        return ((safeDownloaded.toDouble() / total) * 100)
            .toInt()
            .coerceIn(0, 100)
    }
}
