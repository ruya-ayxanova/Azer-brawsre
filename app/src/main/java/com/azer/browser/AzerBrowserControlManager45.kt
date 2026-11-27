class AzerBrowserControlManager45 {

    private val dispatcher =
        AzerBrowserControlDispatcher45()

    private val history =
        AzerBrowserControlHistory45()

    fun execute(
        request: AzerBrowserControlRequest45
    ): AzerBrowserControlResponse45 {

        val response = dispatcher.dispatch(request)

        if (response.success) {
            history.add(request)
        }

        return response
    }

    fun getHistory(): List<AzerBrowserControlRequest45> {
        return history.getAll()
    }

    fun clearHistory() {
        history.clear()
    }
}
