package com.azer.browser.ui

import android.content.Context
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

object SettingsScreen {

    fun create(context: Context): LinearLayout {

        val layout = LinearLayout(context)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(20, 20, 20, 20)
        layout.setBackgroundColor(BrowserTheme.background)

        val title = TextView(context)
        title.text = "Ayarlar"
        title.textSize = 25f
        title.setTextColor(BrowserTheme.text)

        val version = TextView(context)
        version.text = "Azer Browser — Sürüm 1.0"
        version.setTextColor(BrowserTheme.secondaryText)

        val vpn = Button(context)
        vpn.text = "VPN"
        vpn.setOnClickListener {
            Toast.makeText(
                context,
                "VPN bağlantısı sonraki aşamada tamamlanacak.",
                Toast.LENGTH_LONG
            ).show()
        }

        val language = Button(context)
        language.text = "Dil: Türkçe"
        language.setOnClickListener {
            Toast.makeText(
                context,
                "Çoklu dil desteği sonraki aşamada eklenecek.",
                Toast.LENGTH_SHORT
            ).show()
        }

        val privacy = Button(context)
        privacy.text = "Gizlilik Bilgisi"
        privacy.setOnClickListener {
            Toast.makeText(
                context,
                "Gizlilik ayarları geliştiriliyor.",
                Toast.LENGTH_SHORT
            ).show()
        }

        layout.addView(title)
        layout.addView(version)
        layout.addView(vpn)
        layout.addView(language)
        layout.addView(privacy)

        return layout
    }
}
