class AzerBrowserForwardControl45 {

    fun canExecute(state: AzerBrowserControlState45): Boolean {
        return state.canForward
    }

    fun createRequest(): AzerBrowserControlRequest45 {
        return AzerBrowserControlRequest45(
            AzerBrowserControlType45.FORWARD
        )
    }
}
