class AzerBrowserActionDispatcher44 {

    private val validator = AzerBrowserCommandValidator44()

    fun dispatch(command: AzerBrowserCommand44): AzerBrowserCommandResult44 {
        if (!validator.validate(command)) {
            return AzerBrowserCommandResult44(
                false,
                "Geçersiz komut"
            )
        }

        return AzerBrowserCommandResult44(
            true,
            "Komut kabul edildi"
        )
    }
}
