class AzerBrowserLifecycleTracker47 {

    private var currentState =
        AzerBrowserLifecycleState47.CREATED

    fun update(state: AzerBrowserLifecycleState47) {
        currentState = state
    }

    fun getState(): AzerBrowserLifecycleState47 {
        return currentState
    }

    fun isForeground(): Boolean {
        return currentState ==
            AzerBrowserLifecycleState47.RESUMED
    }

    fun isDestroyed(): Boolean {
        return currentState ==
            AzerBrowserLifecycleState47.DESTROYED
    }
}
