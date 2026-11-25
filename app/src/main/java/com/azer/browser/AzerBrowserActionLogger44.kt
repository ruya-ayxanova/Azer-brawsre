class AzerBrowserActionLogger44 {

    private val actions = mutableListOf<AzerBrowserAction44>()

    fun record(action: AzerBrowserAction44) {
        actions.add(action)
    }

    fun getActions(): List<AzerBrowserAction44> {
        return actions.toList()
    }

    fun clear() {
        actions.clear()
    }
}
