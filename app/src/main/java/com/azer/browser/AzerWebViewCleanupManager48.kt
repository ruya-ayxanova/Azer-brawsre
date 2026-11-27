import android.webkit.WebView

class AzerWebViewCleanupManager48 {

    private val stopper = AzerWebViewStopper48()
    private val historyCleaner = AzerWebViewHistoryCleaner48()
    private val parentRemover = AzerWebViewParentRemover48()
    private val destroyer = AzerWebViewDestroyer48()

    fun cleanup(
        id: String,
        webView: WebView
    ): AzerWebViewCleanupResult48 {

        return try {
            stopper.stop(webView)
            parentRemover.remove(webView)
            historyCleaner.clear(webView)
            destroyer.destroy(webView)

            AzerWebViewCleanupResult48(
                success = true,
                resourceId = id,
                message = "WebView kaynakları temizlendi"
            )
        } catch (e: Exception) {
            AzerWebViewCleanupResult48(
                success = false,
                resourceId = id,
                message = e.message ?: "Temizleme hatası"
            )
        }
    }
}
