class AzerBrowserOperationTracker45 {

    private val operations =
        mutableListOf<AzerBrowserOperationResult45>()

    fun record(result: AzerBrowserOperationResult45) {
        operations.add(result)
    }

    fun getOperations(): List<AzerBrowserOperationResult45> {
        return operations.toList()
    }

    fun clear() {
        operations.clear()
    }
}
