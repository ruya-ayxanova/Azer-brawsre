class AzerBrowserNavigationBinder44 {

    fun getNavigationState(
        canGoBack: Boolean,
        canGoForward: Boolean
    ): AzerBrowserBindingState44 {
        return AzerBrowserBindingState44(
            canGoBack = canGoBack,
            canGoForward = canGoForward
        )
    }
}
