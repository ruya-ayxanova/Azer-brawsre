class AzerBrowserResourceManager47 {

    private val registry =
        AzerBrowserResourceRegistry47()

    fun add(resource: AzerBrowserResource47) {
        registry.register(resource)
    }

    fun remove(id: String) {
        registry.remove(id)
    }

    fun releaseAll() {
        registry.clear()
    }

    fun getResources(): List<AzerBrowserResource47> {
        return registry.getAll()
    }
}
