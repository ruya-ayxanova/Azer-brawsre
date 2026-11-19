
package com.azer.browser

import android.content.Context

object HomeScreenFactory {

    fun create(
        context: Context,
        onOpenPage: (String) -> Unit
    ): HomeScreenController {
        return HomeScreenController(
            context.applicationContext,
            onOpenPage
        )
    }
}
