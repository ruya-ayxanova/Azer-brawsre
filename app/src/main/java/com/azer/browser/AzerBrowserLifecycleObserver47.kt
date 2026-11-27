class AzerBrowserLifecycleObserver47 {

    private val events =
        mutableListOf<AzerBrowserLifecycleEvent47>()

    fun onEvent(event: AzerBrowserLifecycleEvent47) {
        events.add(event)
    }

    fun getEvents(): List<AzerBrowserLifecycleEvent47> {
        return events.toList()
    }

    fun clear() {
        events.clear()
    }
}
