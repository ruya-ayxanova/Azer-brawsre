
package com.azer.browser

import android.content.Context

object BookmarkFactory {

    fun create(
        context: Context,
        onOpenUrl: (String) -> Unit
    ): BookmarkController {
        return BookmarkController(
            context,
            onOpenUrl
        )
    }
}
