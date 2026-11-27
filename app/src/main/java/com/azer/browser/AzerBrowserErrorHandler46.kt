class AzerBrowserErrorHandler46 {

    fun handle(error: AzerBrowserError46): String {
        return when (error.code) {
            1 -> "İnternet bağlantısı yoxlanmalıdır."
            2 -> "Səhifə açılmadı."
            3 -> "URL düzgün deyil."
            4 -> "Əməliyyat ləğv edildi."
            else -> error.message
        }
    }
}
