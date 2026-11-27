class AzerBrowserBackControl45 {

    fun canExecute(state: AzerBrowserControlState45): Boolean {
        return state.canBack
    }

    fun createRequest(): AzerBrowserControlRequest45 {
        return AzerBrowserControlRequest45(
            AzerBrowserControlType45.BACK
        )
    }
}
