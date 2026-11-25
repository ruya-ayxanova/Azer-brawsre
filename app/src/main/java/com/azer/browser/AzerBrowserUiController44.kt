class AzerBrowserUiController44 {

    private var state = AzerBrowserBindingState44()

    fun update(newState: AzerBrowserBindingState44) {
        state = newState.copy(
            progress = newState.progress.coerceIn(0, 100)
        )
    }

    fun getState(): AzerBrowserBindingState44 {
        return state
    }
}
