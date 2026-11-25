class AzerBrowserWebViewBinder44 {

    fun canNavigate(url: String): Boolean {
        return url.startsWith("http://") ||
                url.startsWith("https://")
    }

    fun normalizeUrl(url: String): String {
        return url.trim()
    }
}
