class AzerBrowserErrorStore46 {

    private val errors = mutableListOf<AzerBrowserError46>()

    fun add(error: AzerBrowserError46) {
        errors.add(error)
    }

    fun getAll(): List<AzerBrowserError46> {
        return errors.toList()
    }

    fun latest(): AzerBrowserError46? {
        return errors.lastOrNull()
    }

    fun clear() {
        errors.clear()
    }
}
