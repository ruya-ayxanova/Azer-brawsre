class AzerBrowserToolbarBinder44 {

    fun bind(
        state: AzerBrowserBindingState44
    ): AzerBrowserBindingState44 {
        return state.copy(
            progress = state.progress.coerceIn(0, 100)
        )
    }
}
