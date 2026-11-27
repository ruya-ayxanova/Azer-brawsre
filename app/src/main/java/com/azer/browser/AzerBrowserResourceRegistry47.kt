class AzerBrowserResourceRegistry47 {

    private val resources =
        mutableMapOf<String, AzerBrowserResource47>()

    fun register(resource: AzerBrowserResource47) {
        resources[resource.id] = resource
    }

    fun get(id: String): AzerBrowserResource47? {
        return resources[id]
    }

    fun getAll(): List<AzerBrowserResource47> {
        return resources.values.toList()
    }

    fun remove(id: String) {
        resources.remove(id)
    }

    fun clear() {
        resources.clear()
    }

    fun size(): Int {
        return resources.size
    }
}
