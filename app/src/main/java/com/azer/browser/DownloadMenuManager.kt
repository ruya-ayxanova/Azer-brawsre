package com.azer.browser

import android.app.Activity
import android.content.Intent
import android.widget.PopupMenu
import android.view.View

object DownloadMenuManager {

    fun show(
        activity: Activity,
        anchor: View
    ) {
        val popup = PopupMenu(activity, anchor)

        DownloadMenuItems.getItems().forEach {
            popup.menu.add(0, it.id, it.id, "${it.icon} ${it.title}")
        }

        popup.setOnMenuItemClickListener { item ->

            when (item.itemId) {

                1 -> {
                    activity.startActivity(
                        Intent(
                            activity,
                            DownloadListActivity::class.java
                        )
                    )
                }

                2 -> {
                    activity.startActivity(
                        Intent(
                            activity,
                            DownloadListActivity::class.java
                        )
                    )
                }

                3 -> {
                    activity.startActivity(
                        Intent(
                            activity,
                            DownloadSettingsActivity::class.java
                        )
                    )
                }
            }

            true
        }

        popup.show()
    }
}
