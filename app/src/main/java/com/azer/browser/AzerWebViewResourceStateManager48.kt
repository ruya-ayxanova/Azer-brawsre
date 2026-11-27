class AzerWebViewResourceStateManager48 {

    private val states =
        mutableMapOf<String, AzerWebViewResourceState48>()

    fun register(id: String) {
        states[id] = AzerWebViewResourceState48(
            id = id,
            registered = true
        )
    }

    fun update(
        id: String,
        loading: Boolean
    ) {
        val old = states[id] ?: return

        states[id] = old.copy(
            loading = loading
        )
    }

    fun markDestroyed(id: String) {
        val old = states[id] ?: return

        states[id] = old.copy(
            registered = false,
            destroyed = true,
            loading = false
        )
    }

    fun get(id: String): AzerWebViewResourceState48? {
        return states[id]
    }

    fun remove(id: String) {
        states.remove(id)
    }
}
