package com.azer.browser

class AzerToolbarStateManager43 {

    private var state = AzerBrowserToolbarState43()

    fun getState(): AzerBrowserToolbarState43 {
        return state
    }

    fun updateAddress(url: String) {
        state = state.copy(address = url)
    }

    fun updateTitle(title: String) {
        state = state.copy(pageTitle = title)
    }

    fun updateProgress(progress: Int) {
        val safe = progress.coerceIn(0, 100)

        state = state.copy(
            progress = safe,
            loading = safe < 100
        )
    }

    fun updateNavigation(
        back: Boolean,
        forward: Boolean
    ) {
        state = state.copy(
            canGoBack = back,
            canGoForward = forward
        )
    }
}
