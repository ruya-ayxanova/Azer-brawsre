package com.azer.browser

class AzerLoadingController41 {

    private var state = AzerLoadingState41()

    fun start(): AzerLoadingState41 {
        state = AzerLoadingState41(
            progress = 0,
            isLoading = true
        )
        return state
    }

    fun update(progress: Int): AzerLoadingState41 {
        val safeProgress = progress.coerceIn(0, 100)

        state = AzerLoadingState41(
            progress = safeProgress,
            isLoading = safeProgress < 100
        )

        return state
    }

    fun fail(message: String): AzerLoadingState41 {
        state = AzerLoadingState41(
            progress = 0,
            isLoading = false,
            error = message
        )
        return state
    }

    fun getState(): AzerLoadingState41 {
        return state
    }
}
