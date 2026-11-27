class AzerBrowserRuntimeInfoUpdater46 {

    fun update(
        oldInfo: AzerBrowserRuntimeInfo46,
        activeTabs: Int,
        operations: Int,
        errors: Int
    ): AzerBrowserRuntimeInfo46 {

        return oldInfo.copy(
            activeTabCount = activeTabs.coerceAtLeast(0),
            totalOperations = operations.coerceAtLeast(0),
            errorCount = errors.coerceAtLeast(0),
            lastActivityTime = System.currentTimeMillis()
        )
    }
}
