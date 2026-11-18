package com.azer.browser

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Button

class DownloadListActivity : Activity() {

    private lateinit var listView: ListView
    private lateinit var emptyView: TextView
    private lateinit var adapter: DownloadAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }

        val header = TextView(this).apply {
            text = "Azer Browser - İndirmeler"
            textSize = 23f
            setPadding(24, 24, 24, 16)
        }

        val refreshButton = Button(this).apply {
            text = "Listeyi Yenile"
            setOnClickListener {
                refreshDownloads()
            }
        }

        emptyView = TextView(this).apply {
            text = "Henüz indirme bulunmuyor."
            textSize = 18f
            setPadding(24, 24, 24, 24)
            visibility = View.GONE
        }

        listView = ListView(this)

        adapter = DownloadAdapter(
            this,
            mutableListOf()
        )

        listView.adapter = adapter

        layout.addView(header)
        layout.addView(refreshButton)
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
    }

    private fun refreshDownloads() {

        DownloadIntegration.refresh(this)

        val downloads = DownloadRepository.getAll(this)

        adapter.update(downloads)

        emptyView.visibility =
            if (downloads.isEmpty()) View.VISIBLE else View.GONE
    }

    override fun onResume() {
        super.onResume()
        refreshDownloads()
    }
}
