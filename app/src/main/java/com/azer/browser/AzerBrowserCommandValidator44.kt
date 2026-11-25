class AzerBrowserCommandValidator44 {

    fun validate(command: AzerBrowserCommand44): Boolean {
        if (command.action == AzerBrowserAction44.OPEN_URL) {
            return !command.url.isNullOrBlank()
        }
        return true
    }
}
