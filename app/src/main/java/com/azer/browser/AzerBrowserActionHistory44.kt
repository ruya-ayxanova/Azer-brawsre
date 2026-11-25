class AzerBrowserActionHistory44 {

    private val history = mutableListOf<AzerBrowserCommand44>()

    fun add(command: AzerBrowserCommand44) {
        history.add(command)
    }

    fun getHistory(): List<AzerBrowserCommand44> {
        return history.toList()
    }

    fun clear() {
        history.clear()
    }
}
