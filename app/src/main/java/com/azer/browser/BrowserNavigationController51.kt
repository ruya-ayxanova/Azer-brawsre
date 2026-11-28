package com.azer.browser

class BrowserNavigationController51(
    private val engine: BrowserEngineAdapter51
) {

    fun open(url: String) {
        val resolved = BrowserUrlResolver51.resolve(url)
        if (BrowserUrlValidator51.isValid(resolved)) {
            engine.loadUrl(resolved)
        }
    }

    fun reload() {
        engine.reload()
    }

    fun stop() {
        engine.stopLoading()
    }

    fun back(): Boolean {
        return engine.goBack()
    }

    fun forward(): Boolean {
        return engine.goForward()
    }

    fun currentUrl(): String? {
        return engine.currentUrl()
    }

    fun isLoading(): Boolean {
        return engine.isLoading()
    }
}
