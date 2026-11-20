
package com.azer.browser

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast

object BrowserCopyHelper {

    fun copy(context: Context, url: String) {
        if (url.isBlank()) return

        val clipboard = context.getSystemService(
            Context.CLIPBOARD_SERVICE
        ) as ClipboardManager

        clipboard.setPrimaryClip(
            ClipData.newPlainText("Web adresi", url)
        )

        Toast.makeText(
            context,
            "Adres kopyalandı",
            Toast.LENGTH_SHORT
        ).show()
    }
}
