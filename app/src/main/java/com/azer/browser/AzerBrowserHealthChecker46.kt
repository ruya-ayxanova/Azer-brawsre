class AzerBrowserHealthChecker46 {

    fun check(
        health: AzerBrowserHealth46
    ): AzerBrowserHealth46 {
        return health.copy(
            isReady = health.isConnected && !health.hasError
        )
    }
}
