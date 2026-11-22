package com.azer.browser

object TabMenuActionResolver38 {

    fun resolve(
        action: TabMenuAction38
    ): String {

        return when (action.item) {
            TabMenuItem38.OPEN_NEW -> "Yeni sekme aç"
            TabMenuItem38.CLOSE -> "Sekmeyi kapat"
            TabMenuItem38.CLOSE_OTHERS -> "Diğer sekmeleri kapat"
            TabMenuItem38.CLOSE_ALL -> "Bütün sekmeleri kapat"
            TabMenuItem38.DUPLICATE -> "Sekmeyi çoğalt"
            TabMenuItem38.RELOAD -> "Sayfayı yenile"
            TabMenuItem38.COPY_URL -> "Adresi kopyala"
        }
    }
}
