class AzerBrowserControlHistory45 {

    private val history =
        mutableListOf<AzerBrowserControlRequest45>()

    fun add(request: AzerBrowserControlRequest45) {
        history.add(request)
    }

    fun getAll(): List<AzerBrowserControlRequest45> {
        return history.toList()
    }

    fun last(): AzerBrowserControlRequest45? {
        return history.lastOrNull()
    }

    fun clear() {
        history.clear()
    }
}
