package com.azer.browser

object BrowserWebTabFactory39 {

    fun createRegistry(): BrowserWebTabRegistry39 {
        return BrowserWebTabRegistry39()
    }

    fun createStateRepository(): BrowserWebTabStateRepository39 {
        return BrowserWebTabStateRepository39()
    }

    fun createStatusManager(): BrowserWebTabStatusManager39 {
        return BrowserWebTabStatusManager39()
    }

    fun createController(
        registry: BrowserWebTabRegistry39,
        states: BrowserWebTabStateRepository39,
        statuses: BrowserWebTabStatusManager39
    ): BrowserWebTabController39 {
        return BrowserWebTabController39(
            registry,
            states,
            statuses
        )
    }

    fun createLifecycleManager(
        registry: BrowserWebTabRegistry39
    ): BrowserWebTabLifecycleManager39 {
        return BrowserWebTabLifecycleManager39(registry)
    }

    fun createNavigationController(
        registry: BrowserWebTabRegistry39
    ): BrowserWebTabNavigationController39 {
        return BrowserWebTabNavigationController39(registry)
    }
}
