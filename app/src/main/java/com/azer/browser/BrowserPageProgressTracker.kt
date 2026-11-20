
package com.azer.browser

class BrowserPageProgressTracker(
    private val onProgressChanged: (Int) -> Unit
) {

    var progress: Int = 0
        private set

    var isLoading: Boolean = false
        private set

    fun start() {
        progress = 0
        isLoading = true
        onProgressChanged(progress)
    }

    fun update(value: Int) {
        progress = value.coerceIn(0, 100)
        isLoading = progress < 100
        onProgressChanged(progress)
    }

    fun finish() {
        progress = 100
        isLoading = false
        onProgressChanged(progress)
    }
}
