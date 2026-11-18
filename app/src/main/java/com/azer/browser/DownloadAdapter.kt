package com.azer.browser

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView

class DownloadAdapter(
    private val context: Context,
    private var items: MutableList<DownloadItem>
) : BaseAdapter() {

    fun update(newItems: List<DownloadItem>) {
        items = newItems.toMutableList()
        notifyDataSetChanged()
    }

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): DownloadItem = items[position]

    override fun getItemId(position: Int): Long = items[position].id

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {

        val item = getItem(position)

        val layout = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(24, 18, 24, 18)
        }

        val title = TextView(context).apply {
            text = item.fileName.ifBlank { item.title }
            textSize = 17f
        }

        val status = TextView(context).apply {
            text = when (item.status) {
                DownloadStatus.PENDING -> "Bekliyor"
                DownloadStatus.RUNNING -> "İndiriliyor"
                DownloadStatus.COMPLETED -> "Tamamlandı"
                DownloadStatus.FAILED -> "Başarısız"
                DownloadStatus.PAUSED -> "Duraklatıldı"
                DownloadStatus.CANCELLED -> "İptal edildi"
            }
            textSize = 14f
        }

        val size = TextView(context).apply {
            text = "${DownloadUtils.formatSize(item.downloadedBytes)} / " +
                    DownloadUtils.formatSize(item.totalBytes)
            textSize = 13f
        }

        val progress = TextView(context).apply {
            text = DownloadUtils.formatProgress(item.progress)
            textSize = 14f
        }

        layout.addView(title)
        layout.addView(status)
        layout.addView(size)
        layout.addView(progress)

        layout.setBackgroundResource(
            android.R.drawable.list_selector_background
        )

        layout.setOnClickListener {
            if (item.status == DownloadStatus.COMPLETED) {
                DownloadActions.open(context, item.id)
            }
        }

        layout.setOnLongClickListener {
            DownloadActions.delete(context, item.id)
            update(DownloadRepository.getAll(context))
            true
        }

        return layout
    }
}
