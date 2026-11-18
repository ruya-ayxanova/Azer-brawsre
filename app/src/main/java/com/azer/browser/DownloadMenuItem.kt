package com.azer.browser

data class DownloadMenuItem(
    val id: Int,
    val title: String,
    val icon: String
)

object DownloadMenuItems {

    fun getItems(): List<DownloadMenuItem> {
        return listOf(
            DownloadMenuItem(
                1,
                "İndirilenler",
                "⬇"
            ),
            DownloadMenuItem(
                2,
                "İndirme geçmişi",
                "📁"
            ),
            DownloadMenuItem(
                3,
                "İndirme ayarları",
                "⚙"
            )
        )
    }
}
