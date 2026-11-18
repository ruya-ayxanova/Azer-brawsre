package com.azer.browser.ui.downloads

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.azer.browser.download.system.DownloadRecord
import com.azer.browser.download.system.DownloadState

object DownloadRowView {

    fun create(
        context: Context,
        record: DownloadRecord,
        onCancel: () -> Unit,
        onOpen: () -> Unit
    ): LinearLayout {

        val card = LinearLayout(context)
        card.orientation = LinearLayout.VERTICAL
        card.setPadding(16, 12, 16, 12)
        card.setBackgroundColor(Color.rgb(27, 39, 49))

        val name = TextView(context)
        name.text = record.fileName
        name.textSize = 16f
        name.setTextColor(Color.WHITE)

        val status = TextView(context)
        status.text = DownloadStatusLabel.get(record.status)
        status.textSize = 13f
        status.setTextColor(Color.LTGRAY)

        val size = TextView(context)
        size.text = DownloadProgressFormatter.size(
            record.downloadedBytes,
            record.totalBytes
        )
        size.textSize = 12f
        size.setTextColor(Color.LTGRAY)

        val progress = ProgressBar(
            context,
            null,
            android.R.attr.progressBarStyleHorizontal
        )

        progress.max = 100
        progress.progress = record.progress

        if (record.status == DownloadState.RUNNING ||
            record.status == DownloadState.PENDING
        ) {
            progress.visibility = android.view.View.VISIBLE
        } else {
            progress.visibility = android.view.View.GONE
        }

        val percent = TextView(context)
        percent.text = DownloadProgressFormatter.percent(record.progress)
        percent.setTextColor(Color.WHITE)

        val buttons = LinearLayout(context)
        buttons.orientation = LinearLayout.HORIZONTAL
        buttons.gravity = Gravity.CENTER_VERTICAL

        if (record.status == DownloadState.SUCCESSFUL) {
            val open = android.widget.Button(context)
            open.text = "Dosyayı Aç"
            open.setOnClickListener {
                onOpen()
            }
            buttons.addView(open)
        }

        if (record.status == DownloadState.RUNNING ||
            record.status == DownloadState.PENDING ||
            record.status == DownloadState.PAUSED
        ) {
            buttons.addView(
                DownloadCancelAction.create(context) {
                    onCancel()
                }
            )
        }

        card.addView(name)
        card.addView(status)
        card.addView(size)
        card.addView(progress)
        card.addView(percent)
        card.addView(buttons)

        return card
    }
}
