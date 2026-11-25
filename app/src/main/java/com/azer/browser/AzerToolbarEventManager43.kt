package com.azer.browser

class AzerToolbarEventManager43 {

    private val listeners =
        mutableListOf<(AzerToolbarAction43) -> Unit>()

    fun addListener(
        listener: (AzerToolbarAction43) -> Unit
    ) {
        listeners.add(listener)
    }

    fun dispatch(action: AzerToolbarAction43) {
        listeners.toList().forEach {
            it(action)
        }
    }

    fun clearListeners() {
        listeners.clear()
    }
}
