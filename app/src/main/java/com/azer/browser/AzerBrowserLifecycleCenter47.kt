class AzerBrowserLifecycleCenter47 {

    private val lifecycle =
        AzerBrowserLifecycleManager47()

    private val background =
        AzerBrowserBackgroundManager47()

    private val resources =
        AzerBrowserResourceManager47()

    private val validator =
        AzerBrowserLifecycleValidator47()

    fun onCreated() {
        lifecycle.dispatch(
            AzerBrowserLifecycleState47.CREATED
        )
    }

    fun onStarted() {
        lifecycle.dispatch(
            AzerBrowserLifecycleState47.STARTED
        )
    }

    fun onResumed() {
        background.enterForeground()
        lifecycle.dispatch(
            AzerBrowserLifecycleState47.RESUMED
        )
    }

    fun onPaused() {
        background.enterBackground()
        lifecycle.dispatch(
            AzerBrowserLifecycleState47.PAUSED
        )
    }

    fun onStopped() {
        lifecycle.dispatch(
            AzerBrowserLifecycleState47.STOPPED
        )
    }

    fun onDestroyed() {
        resources.releaseAll()
        lifecycle.dispatch(
            AzerBrowserLifecycleState47.DESTROYED
        )
    }

    fun registerResource(
        resource: AzerBrowserResource47
    ) {
        resources.add(resource)
    }

    fun canResume(): Boolean {
        return validator.canResume(
            lifecycle.getState()
        )
    }

    fun getSummary(): AzerBrowserLifecycleSummary47 {
        val state = lifecycle.getState()

        return AzerBrowserLifecycleSummary47(
            currentState = state,
            isForeground = !background.getState().isInBackground,
            isBackground = background.getState().isInBackground,
            resourceCount = resources.getResources().size,
            eventCount = lifecycle.getEvents().size
        )
    }
}
