class AzerBrowserControlDispatcher45 {

    private val validator =
        AzerBrowserControlValidator45()

    fun dispatch(
        request: AzerBrowserControlRequest45
    ): AzerBrowserControlResponse45 {

        val valid = validator.isValid(request)

        return AzerBrowserControlResponse45(
            success = valid,
            control = request.type,
            message = if (valid) {
                "Komut kabul edildi"
            } else {
                "Geçersiz komut"
            }
        )
    }
}
