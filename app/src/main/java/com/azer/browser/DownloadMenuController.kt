package com.azer.browser

import android.app.Activity
import android.view.View
import android.widget.PopupMenu

object DownloadMenuController {

    fun show(
        activity: Activity,
        anchor: View
    ) {
        val menu = PopupMenu(activity, anchor)

        menu.menu.add("İndirilenler").setOnMenuItemClickListener {
            DownloadLauncher.open(activity)
            true
        }

        menu.menu.add("İndirme ayarları").setOnMenuItemClickListener {
            DownloadIntegration.openSettings(activity)
            true
        }

        menu.menu.add("İndirme listesini yenile").setOnMenuItemClickListener {
            DownloadIntegration.refresh(activity)
            true
        }

        menu.show()
    }
}
