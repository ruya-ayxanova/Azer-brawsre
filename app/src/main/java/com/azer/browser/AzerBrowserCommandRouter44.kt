class AzerBrowserCommandRouter44 {

    fun route(command: AzerBrowserCommand44): String {
        return when (command.action) {
            AzerBrowserAction44.GO_BACK -> "back"
            AzerBrowserAction44.GO_FORWARD -> "forward"
            AzerBrowserAction44.RELOAD -> "reload"
            AzerBrowserAction44.STOP_LOADING -> "stop"
            AzerBrowserAction44.GO_HOME -> "home"
            AzerBrowserAction44.OPEN_URL -> "open_url"
            AzerBrowserAction44.NEW_TAB -> "new_tab"
            AzerBrowserAction44.CLOSE_TAB -> "close_tab"
        }
    }
}
