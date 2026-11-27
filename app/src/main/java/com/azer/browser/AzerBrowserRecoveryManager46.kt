class AzerBrowserRecoveryManager46 {

    fun getAction(
        error: AzerBrowserError46
    ): AzerBrowserRecoveryAction46 {

        if (!error.recoverable) {
            return AzerBrowserRecoveryAction46.IGNORE
        }

        return when (error.code) {
            1 -> AzerBrowserRecoveryAction46.RETRY
            2 -> AzerBrowserRecoveryAction46.RELOAD
            3 -> AzerBrowserRecoveryAction46.GO_HOME
            else -> AzerBrowserRecoveryAction46.RETRY
        }
    }
}
