package com.azer.browser

class ReaderModeActionHandler(
    private val controller: ReaderModeController,
    private val onRefresh: () -> Unit,
    private val onClose: () -> Unit
) {

    fun execute(action: ReaderModeAction) {
        when (action) {
            ReaderModeAction.OPEN -> onRefresh()
            ReaderModeAction.CLOSE -> onClose()

            ReaderModeAction.INCREASE_FONT -> {
                controller.increaseFont()
                onRefresh()
            }

            ReaderModeAction.DECREASE_FONT -> {
                controller.decreaseFont()
                onRefresh()
            }

            ReaderModeAction.TOGGLE_THEME -> {
                controller.toggleDarkMode()
                onRefresh()
            }

            ReaderModeAction.TOGGLE_FONT -> {
                controller.toggleSerifFont()
                onRefresh()
            }

            ReaderModeAction.RESET -> {
                controller.resetSettings()
                onRefresh()
            }
        }
    }
}
