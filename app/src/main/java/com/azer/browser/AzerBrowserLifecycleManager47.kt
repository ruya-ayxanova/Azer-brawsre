class AzerBrowserLifecycleManager47 {

    private val tracker =
        AzerBrowserLifecycleTracker47()

    private val observer =
        AzerBrowserLifecycleObserver47()

    fun dispatch(state: AzerBrowserLifecycleState47) {
        tracker.update(state)

        observer.onEvent(
            AzerBrowserLifecycleEvent47(state)
        )
    }

    fun getState(): AzerBrowserLifecycleState47 {
        return tracker.getState()
    }

    fun getEvents(): List<AzerBrowserLifecycleEvent47> {
        return observer.getEvents()
    }
}
