package com.azer.browser.ui.downloads

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import com.azer.browser.download.system.DownloadRecord
import com.azer.browser.download.system.DownloadScreenController

object DownloadListScreen {

    fun create(context: Context): View {

        val controller = DownloadScreenController(context)

        val root = LinearLayout(context)
        root.orientation = LinearLayout.VERTICAL
        root.setBackgroundColor(Color.rgb(16, 24, 32))
        root.setPadding(12, 12, 12, 12)

        val title = TextView(context)
        title.text = "İndirme Yöneticisi"
        title.textSize = 23f
        title.setTextColor(Color.WHITE)
        title.setPadding(8, 12, 8, 12)

        val refresh = DownloadRefreshButton.create(context) {
            render()
        }

        val scroll = ScrollView(context)

        val list = LinearLayout(context)
        list.orientation = LinearLayout.VERTICAL

        scroll.addView(list)

        root.addView(title)
        root.addView(refresh)
        root.addView(
            scroll,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        fun renderList() {
            list.removeAllViews()

            val downloads: List<DownloadRecord> =
                try {
                    controller.getDownloads()
                } catch (e: Exception) {
                    emptyList()
                }

            if (downloads.isEmpty()) {
                list.addView(
                    DownloadEmptyState.create(context)
                )
                return
            }

            downloads.asReversed().forEach { record ->

                val row = DownloadRowView.create(
                    context,
                    record,
                    onCancel = {
                        controller.cancel(record.id)
                        Toast.makeText(
                            context,
                            "İndirme iptal edildi.",
                            Toast.LENGTH_SHORT
                        ).show()
                        renderList()
                    },
                    onOpen = {
                        DownloadOpenAction.open(
                            context,
                            record.id
                        )
                    }
                )

                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )

                params.setMargins(0, 8, 0, 8)

                list.addView(row, params)
            }
        }

        fun refreshList() {
            renderList()
        }

        renderList()

        refresh.setOnClickListener {
            refreshList()
        }

        return root
    }
}
