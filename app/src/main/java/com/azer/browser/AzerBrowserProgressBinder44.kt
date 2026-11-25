class AzerBrowserProgressBinder44 {

    fun normalizeProgress(progress: Int): Int {
        return progress.coerceIn(0, 100)
    }

    fun shouldShowProgress(progress: Int): Boolean {
        return progress in 1..99
    }
}
