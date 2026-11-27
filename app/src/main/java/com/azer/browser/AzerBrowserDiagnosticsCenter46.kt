class AzerBrowserDiagnosticsCenter46 {

    private val healthChecker =
        AzerBrowserHealthChecker46()

    private val connectionMonitor =
        AzerBrowserConnectionMonitor46()

    private val diagnosticManager =
        AzerBrowserDiagnosticManager46()

    private val formatter =
        AzerBrowserDiagnosticFormatter46()

    fun createReport(
        connected: Boolean,
        activeTabs: Int,
        operations: Int,
        errors: Int,
        hasError: Boolean = false,
        errorMessage: String = ""
    ): String {

        val connection =
            connectionMonitor.evaluate(connected)

        val health = healthChecker.check(
            AzerBrowserHealth46(
                isConnected = connected,
                hasError = hasError,
                errorMessage = errorMessage
            )
        )

        val runtime = AzerBrowserRuntimeInfo46(
            activeTabCount = activeTabs,
            totalOperations = operations,
            errorCount = errors,
            lastActivityTime = System.currentTimeMillis()
        )

        val diagnostic = diagnosticManager.create(
            health,
            connection,
            runtime
        )

        return formatter.format(diagnostic)
    }
}
