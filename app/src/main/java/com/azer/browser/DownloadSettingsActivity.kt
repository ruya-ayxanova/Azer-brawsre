package com.azer.browser

import android.app.Activity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Switch
import android.widget.EditText
import android.widget.Button
import android.widget.Toast

class DownloadSettingsActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(24, 24, 24, 24)
        }

        val title = TextView(this).apply {
            text = "İndirme Ayarları"
            textSize = 25f
        }

        val wifiSwitch = Switch(this).apply {
            text = "Yalnızca Wi-Fi ile indir"
            isChecked = DownloadSettings.getWifiOnly(this@DownloadSettingsActivity)
        }

        val notificationSwitch = Switch(this).apply {
            text = "İndirme bildirimleri"
            isChecked = DownloadSettings.getNotificationEnabled(this@DownloadSettingsActivity)
        }

        val folderInput = EditText(this).apply {
            hint = "İndirme klasörü"
            setText(DownloadSettings.getDownloadFolder(this@DownloadSettingsActivity))
        }

        val saveButton = Button(this).apply {
            text = "Ayarları Kaydet"

            setOnClickListener {
                DownloadSettings.setWifiOnly(
                    this@DownloadSettingsActivity,
                    wifiSwitch.isChecked
                )

                DownloadSettings.setNotificationEnabled(
                    this@DownloadSettingsActivity,
                    notificationSwitch.isChecked
                )

                DownloadSettings.setDownloadFolder(
                    this@DownloadSettingsActivity,
                    folderInput.text.toString()
                )

                Toast.makeText(
                    this@DownloadSettingsActivity,
                    "Ayarlar kaydedildi",
                    Toast.LENGTH_SHORT
                ).show()

                finish()
            }
        }

        layout.addView(title)
        layout.addView(wifiSwitch)
        layout.addView(notificationSwitch)
        layout.addView(folderInput)
        layout.addView(saveButton)

        setContentView(layout)
    }
}
