class AzerBrowserIntegrationFacade44 {

    private val dispatcher = AzerBrowserActionDispatcher44()
    private val router = AzerBrowserCommandRouter44()

    fun execute(
        command: AzerBrowserCommand44
    ): AzerBrowserCommandResult44 {
        val result = dispatcher.dispatch(command)

        if (!result.success) {
            return result
        }

        router.route(command)

        return AzerBrowserCommandResult44(
            true,
            "İşlem hazır: ${command.action}"
        )
    }
}
