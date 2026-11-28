package com.azer.browser

class BrowserLoadingTracker51 {

    private var loading = false
    private var progress = 0

    fun start() {
        loading = true
        progress = 0
    }

    fun update(value: Int) {
        progress = value.coerceIn(0, 100)

        if (progress >= 100) {
            loading = false
        }
    }

    fun stop() {
        loading = false
    }

    fun isLoading(): Boolean {
        return loading
    }

    fun getProgress(): Int {
        return progress
    }

    fun reset() {
        loading = false
        progress = 0
    }
}
