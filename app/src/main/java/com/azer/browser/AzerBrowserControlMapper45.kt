class AzerBrowserControlMapper45 {

    fun map(
        type: AzerBrowserControlType45
    ): String {
        return when (type) {
            AzerBrowserControlType45.BACK -> "back"
            AzerBrowserControlType45.FORWARD -> "forward"
            AzerBrowserControlType45.RELOAD -> "reload"
            AzerBrowserControlType45.STOP -> "stop"
            AzerBrowserControlType45.HOME -> "home"
            AzerBrowserControlType45.SEARCH -> "search"
            AzerBrowserControlType45.NEW_TAB -> "new_tab"
            AzerBrowserControlType45.CLOSE_TAB -> "close_tab"
        }
    }
}
