
package com.azer.browser

import android.content.Context

object BrowserTabbedScreenFactory {

    fun create(context: Context): BrowserTabbedScreenController {
        return BrowserTabbedScreenController(context)
    }
}
