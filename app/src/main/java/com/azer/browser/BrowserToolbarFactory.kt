
package com.azer.browser

import android.content.Context

object BrowserToolbarFactory {

    fun create(
        context: Context,
        callbacks: BrowserToolbarCallbacks
    ): BrowserToolbarController {
        return BrowserToolbarController(
            context,
            callbacks
        )
    }
}
