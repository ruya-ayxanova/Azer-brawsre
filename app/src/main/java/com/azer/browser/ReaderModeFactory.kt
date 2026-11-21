package com.azer.browser

import android.content.Context

object ReaderModeFactory {

    fun createController(context: Context): ReaderModeController {
        return ReaderModeController(context)
    }

    fun createManager(context: Context): ReaderModeManager {
        return ReaderModeManager(context)
    }

    fun createView(context: Context): ReaderModeView {
        return ReaderModeView(context)
    }

    fun createLayout(context: Context): ReaderModeLayout {
        return ReaderModeLayout(context)
    }

    fun createToolbar(
        context: Context,
        controller: ReaderModeController,
        onRefresh: () -> Unit
    ): ReaderModeToolbar {
        return ReaderModeToolbar(context, controller, onRefresh)
    }
}
