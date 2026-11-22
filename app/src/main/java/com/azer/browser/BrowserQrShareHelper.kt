package com.azer.browser

import android.content.Context
import android.content.Intent

object BrowserQrShareHelper {

    fun share(context: Context, content: String) {
        if (!BrowserQrValidator.isValidContent(content)) return

        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, content)
        }

        context.startActivity(
            Intent.createChooser(intent, "QR içeriğini paylaş")
        )
    }
}
