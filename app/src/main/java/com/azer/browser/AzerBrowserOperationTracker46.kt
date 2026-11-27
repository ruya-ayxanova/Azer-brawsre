class AzerBrowserOperationTracker46 {

    private val operations =
        mutableListOf<AzerBrowserOperationResult46>()

    fun record(result: AzerBrowserOperationResult46) {
        operations.add(result)
    }

    fun getOperations(): List<AzerBrowserOperationResult46> {
        return operations.toList()
    }

    fun clear() {
        operations.clear()
    }
}
