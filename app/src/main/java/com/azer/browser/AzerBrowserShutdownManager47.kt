class AzerBrowserShutdownManager47 {

    fun createResult(
        releasedResources: Int
    ): AzerBrowserShutdownResult47 {

        return AzerBrowserShutdownResult47(
            completed = true,
            releasedResources = releasedResources.coerceAtLeast(0),
            message = "Kapatma işlemi tamamlandı"
        )
    }
}
