package com.azer.browser

import android.content.Context

object DownloadRepository {

    fun getAll(context: Context): MutableList<DownloadItem> {
        return DownloadStorage.getDownloads(context)
    }

    fun add(context: Context, item: DownloadItem) {
        val list = getAll(context)
        list.removeAll { it.id == item.id }
        list.add(0, item)
        DownloadStorage.saveDownloads(context, list)
    }

    fun update(context: Context, item: DownloadItem) {
        val list = getAll(context)
        val index = list.indexOfFirst { it.id == item.id }

        if (index >= 0) {
            list[index] = item
        } else {
            list.add(0, item)
        }

        DownloadStorage.saveDownloads(context, list)
    }

    fun remove(context: Context, id: Long) {
        val list = getAll(context)
        list.removeAll { it.id == id }
        DownloadStorage.saveDownloads(context, list)
    }

    fun clear(context: Context) {
        DownloadStorage.saveDownloads(context, emptyList())
    }

    fun find(context: Context, id: Long): DownloadItem? {
        return getAll(context).find { it.id == id }
    }
}
