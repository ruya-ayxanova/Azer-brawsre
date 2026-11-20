
package com.azer.browser

class BrowserToolbarActions(
    private val callbacks: BrowserToolbarCallbacks
) {

    fun submitAddress(value: String) {
        val destination = BrowserSearchEngine.resolveInput(value)

        if (destination.isNotEmpty()) {
            callbacks.onAddressSubmitted(destination)
        }
    }

    fun back() {
        callbacks.onBackClicked()
    }

    fun forward() {
        callbacks.onForwardClicked()
    }

    fun reload() {
        callbacks.onReloadClicked()
    }

    fun home() {
        callbacks.onHomeClicked()
    }

    fun share(url: String) {
        if (url.isNotBlank()) {
            callbacks.onShareClicked(url)
        }
    }

    fun copy(url: String) {
        if (url.isNotBlank()) {
            callbacks.onCopyClicked(url)
        }
    }
}
