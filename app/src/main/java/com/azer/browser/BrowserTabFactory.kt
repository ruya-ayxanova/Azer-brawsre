
package com.azer.browser

import android.content.Context

object BrowserTabFactory {

    fun create(
        context: Context,
        listener: BrowserTabListener
    ): BrowserTabController {
        return BrowserTabController(
            context,
            listener
        )
    }
}
