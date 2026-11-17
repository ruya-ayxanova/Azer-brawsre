package com.azer.browser.ui

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

object DownloadScreen {

    fun create(context: Context): LinearLayout {

        val layout = LinearLayout(context)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(20, 20, 20, 20)
        layout.setBackgroundColor(BrowserTheme.background)

        val title = TextView(context)
        title.text = "İndirilen Dosyalar"
        title.textSize = 23f
        title.setTextColor(BrowserTheme.text)

        val info = TextView(context)
        info.text = "İndirilen dosyalar telefonun İndirilenler klasörüne kaydedilir."
        info.textSize = 14f
        info.setTextColor(BrowserTheme.secondaryText)

        val folder = TextView(context)
        folder.text = "Klasör: ${Environment.DIRECTORY_DOWNLOADS}"
        folder.setTextColor(BrowserTheme.secondaryText)

        val count = TextView(context)
        count.setTextColor(BrowserTheme.primary)
        count.textSize = 17f
        count.text = "İndirme bilgisi yükleniyor..."

        try {
            val manager = context.getSystemService(
                Context.DOWNLOAD_SERVICE
            ) as DownloadManager

            val cursor = manager.query(
                DownloadManager.Query()
            )

            var total = 0
            cursor?.use {
                while (it.moveToNext()) {
                    total++
                }
            }

            count.text = "Toplam indirme kaydı: $total"
        } catch (e: Exception) {
            count.text = "İndirme kayıtları okunamadı."
        }

        layout.addView(title)
        layout.addView(info)
        layout.addView(folder)
        layout.addView(count)

        return layout
    }
}
