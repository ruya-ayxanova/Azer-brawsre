class AzerBrowserStateCoordinator44 {

    private val controller = AzerBrowserUiController44()

    fun synchronize(
        state: AzerBrowserBindingState44
    ): AzerBrowserBindingState44 {
        controller.update(state)
        return controller.getState()
    }
}
