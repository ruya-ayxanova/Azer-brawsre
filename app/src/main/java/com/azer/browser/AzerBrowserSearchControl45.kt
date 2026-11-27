class AzerBrowserSearchControl45 {

    fun createRequest(
        text: String
    ): AzerBrowserControlRequest45 {
        return AzerBrowserControlRequest45(
            type = AzerBrowserControlType45.SEARCH,
            value = text.trim()
        )
    }
}
