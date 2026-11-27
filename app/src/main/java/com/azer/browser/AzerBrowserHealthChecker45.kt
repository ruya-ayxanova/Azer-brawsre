class AzerBrowserHealthChecker45 {

    fun check(health: AzerBrowserHealth45): AzerBrowserHealth45 {
        return health.copy(
            isReady = health.isConnected && !health.hasError
        )
    }
}
