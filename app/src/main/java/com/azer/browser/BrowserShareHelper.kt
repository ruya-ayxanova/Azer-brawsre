
package com.azer.browser

import android.content.Context
import android.content.Intent

object BrowserShareHelper {

    fun share(context: Context, url: String) {
        if (url.isBlank()) return

        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, url)
        }

        val chooser = Intent.createChooser(
            intent,
            "Sayfayı paylaş"
        ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        context.startActivity(chooser)
    }
}
