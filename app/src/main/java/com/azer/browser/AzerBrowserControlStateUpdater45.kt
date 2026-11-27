class AzerBrowserControlStateUpdater45 {

    fun update(
        oldState: AzerBrowserControlState45,
        newState: AzerBrowserControlState45
    ): AzerBrowserControlState45 {

        return oldState.copy(
            url = newState.url,
            title = newState.title,
            loading = newState.loading,
            progress = newState.progress.coerceIn(0, 100),
            canBack = newState.canBack,
            canForward = newState.canForward
        )
    }
}
