class AzerBrowserCleanupManager47 {

    fun createPlan(
        state: AzerBrowserLifecycleState47
    ): List<AzerBrowserCleanupAction47> {

        return when (state) {
            AzerBrowserLifecycleState47.PAUSED ->
                listOf(
                    AzerBrowserCleanupAction47.RELEASE_MEDIA
                )

            AzerBrowserLifecycleState47.STOPPED ->
                listOf(
                    AzerBrowserCleanupAction47.CLEAR_CACHE
                )

            AzerBrowserLifecycleState47.DESTROYED ->
                listOf(
                    AzerBrowserCleanupAction47.RELEASE_ALL
                )

            else -> emptyList()
        }
    }
}
