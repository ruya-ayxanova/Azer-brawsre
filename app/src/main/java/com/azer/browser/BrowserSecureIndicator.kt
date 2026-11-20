
package com.azer.browser

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.TextView

class BrowserSecureIndicator(context: Context) :
    TextView(context) {

    init {
        textSize = 17f
        gravity = Gravity.CENTER
        setPadding(8, 4, 8, 4)
    }

    fun update(url: String) {
        val secure = try {
            java.net.URI(url).scheme.equals(
                "https",
                ignoreCase = true
            )
        } catch (e: Exception) {
            false
        }

        text = if (secure) "🔒" else "ⓘ"

        setTextColor(
            if (secure) Color.rgb(27, 120, 70)
            else Color.DKGRAY
        )

        contentDescription = if (secure) {
            "HTTPS bağlantısı"
        } else {
            "Güvenli HTTPS bağlantısı doğrulanmadı"
        }
    }
}
