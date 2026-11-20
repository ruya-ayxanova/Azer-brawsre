
package com.azer.browser

class BrowserToolbarStateManager {

    private var currentState = BrowserToolbarState()

    fun getState(): BrowserToolbarState {
        return currentState
    }

    fun updateUrl(url: String) {
        currentState = currentState.copy(
            url = url,
            isSecure = url.startsWith(
                "https://",
                ignoreCase = true
            )
        )
    }

    fun updateTitle(title: String) {
        currentState = currentState.copy(title = title)
    }

    fun updateProgress(progress: Int) {
        val safeProgress = progress.coerceIn(0, 100)

        currentState = currentState.copy(
            progress = safeProgress,
            isLoading = safeProgress < 100
        )
    }

    fun updateNavigation(
        canGoBack: Boolean,
        canGoForward: Boolean
    ) {
        currentState = currentState.copy(
            canGoBack = canGoBack,
            canGoForward = canGoForward
        )
    }

    fun reset() {
        currentState = BrowserToolbarState()
    }
}
