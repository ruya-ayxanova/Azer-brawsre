package com.azer.browser

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView

class DownloadListActivity : Activity() {

    private lateinit var listView: ListView
    private lateinit var emptyView: TextView
    private lateinit var adapter: DownloadAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DownloadNotificationHelper.createChannel(this)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }

        val header = TextView(this).apply {
            text = "İndirmeler"
            textSize = 24f
            setPadding(24, 24, 24, 24)
        }

        listView = ListView(this)

        emptyView = TextView(this).apply {
            text = "Henüz indirme bulunmuyor."
            textSize = 18f
            setPadding(24, 24, 24, 24)
            visibility = View.GONE
        }

        adapter = DownloadAdapter(this, mutableListOf())
        listView.adapter = adapter

        layout.addView(header)
        layout.addView(emptyView)
        layout.addView(
            listView,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        setContentView(layout)

        refreshDownloads()
    }

    fun refreshDownloads() {
        val downloads = DownloadRepository.getAll(this)

        adapter.update(downloads)

        emptyView.visibility =
            if (downloads.isEmpty()) View.VISIBLE else View.GONE
    }

    override fun onResume() {
        super.onResume()

        if (::adapter.isInitialized) {
            refreshDownloads()
        }
    }
}
