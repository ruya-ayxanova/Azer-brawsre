class AzerBrowserBackgroundManager47 {

    private var state =
        AzerBrowserBackgroundState47()

    fun enterBackground() {
        state = state.copy(
            isInBackground = true,
            backgroundTime = System.currentTimeMillis()
        )
    }

    fun enterForeground() {
        state = state.copy(
            isInBackground = false,
            lastForegroundTime = System.currentTimeMillis()
        )
    }

    fun getState(): AzerBrowserBackgroundState47 {
        return state
    }
}
