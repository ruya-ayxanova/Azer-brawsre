class AzerBrowserLifecycleValidator47 {

    fun canResume(
        state: AzerBrowserLifecycleState47
    ): Boolean {
        return state != AzerBrowserLifecycleState47.DESTROYED
    }

    fun canShutdown(
        state: AzerBrowserLifecycleState47
    ): Boolean {
        return state != AzerBrowserLifecycleState47.DESTROYED
    }
}
