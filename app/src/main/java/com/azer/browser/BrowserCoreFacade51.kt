package com.azer.browser

class BrowserCoreFacade51(
    private val engine: BrowserEngineAdapter51,
    val config: BrowserCoreConfig51 =
        BrowserCoreConfig51()
) {

    val eventBus = BrowserCoreEventBus51()

    val loadingTracker = BrowserLoadingTracker51()

    private val navigation =
        BrowserNavigationController51(engine)

    private val security =
        BrowserSecurityPolicy51()

    fun open(url: String): Boolean {
        val resolved = BrowserUrlResolver51.resolve(url)

        if (!security.allowNavigation(resolved)) {
            eventBus.emit(
                BrowserCoreEvent51.NavigationFailed(
                    resolved,
                    "Geçersiz adres"
                )
            )
            return false
        }

        loadingTracker.start()

        eventBus.emit(
            BrowserCoreEvent51.NavigationStarted(resolved)
        )

        navigation.open(resolved)
        return true
    }

    fun reload() {
        navigation.reload()
    }

    fun stop() {
        navigation.stop()
        loadingTracker.stop()
        eventBus.emit(
            BrowserCoreEvent51.LoadingStopped
        )
    }

    fun back(): Boolean {
        return navigation.back()
    }

    fun forward(): Boolean {
        return navigation.forward()
    }

    fun currentUrl(): String? {
        return navigation.currentUrl()
    }

    fun isLoading(): Boolean {
        return loadingTracker.isLoading()
    }

    fun updateProgress(progress: Int) {
        loadingTracker.update(progress)

        eventBus.emit(
            BrowserCoreEvent51.ProgressChanged(
                progress.coerceIn(0, 100)
            )
        )
    }
}
