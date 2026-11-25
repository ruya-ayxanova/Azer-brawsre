package com.azer.browser

data class AzerLoadingState41(
    val progress: Int = 0,
    val isLoading: Boolean = false,
    val error: String? = null
) {
    val isComplete: Boolean
        get() = progress >= 100 && !isLoading

    val hasError: Boolean
        get() = !error.isNullOrEmpty()
}
