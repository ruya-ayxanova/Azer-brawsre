class AzerBrowserControlCenter45 {

    private val manager =
        AzerBrowserControlManager45()

    fun back(): AzerBrowserControlResponse45 {
        return manager.execute(
            AzerBrowserControlRequest45(
                AzerBrowserControlType45.BACK
            )
        )
    }

    fun forward(): AzerBrowserControlResponse45 {
        return manager.execute(
            AzerBrowserControlRequest45(
                AzerBrowserControlType45.FORWARD
            )
        )
    }

    fun reload(): AzerBrowserControlResponse45 {
        return manager.execute(
            AzerBrowserControlRequest45(
                AzerBrowserControlType45.RELOAD
            )
        )
    }

    fun stop(): AzerBrowserControlResponse45 {
        return manager.execute(
            AzerBrowserControlRequest45(
                AzerBrowserControlType45.STOP
            )
        )
    }

    fun home(): AzerBrowserControlResponse45 {
        return manager.execute(
            AzerBrowserControlRequest45(
                AzerBrowserControlType45.HOME
            )
        )
    }

    fun search(
        text: String
    ): AzerBrowserControlResponse45 {
        return manager.execute(
            AzerBrowserControlRequest45(
                AzerBrowserControlType45.SEARCH,
                text
            )
        )
    }

    fun newTab(): AzerBrowserControlResponse45 {
        return manager.execute(
            AzerBrowserControlRequest45(
                AzerBrowserControlType45.NEW_TAB
            )
        )
    }

    fun closeTab(): AzerBrowserControlResponse45 {
        return manager.execute(
            AzerBrowserControlRequest45(
                AzerBrowserControlType45.CLOSE_TAB
            )
        )
    }
}
