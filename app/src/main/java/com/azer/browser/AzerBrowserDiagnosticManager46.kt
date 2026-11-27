class AzerBrowserDiagnosticManager46 {

    fun create(
        health: AzerBrowserHealth46,
        connection: AzerBrowserConnectionState46,
        runtime: AzerBrowserRuntimeInfo46
    ): AzerBrowserDiagnostic46 {

        return AzerBrowserDiagnostic46(
            health = health,
            connection = connection,
            runtime = runtime
        )
    }
}
