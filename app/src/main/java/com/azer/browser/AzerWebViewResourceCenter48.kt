import android.webkit.WebView

class AzerWebViewResourceCenter48 {

    private val registry =
        AzerWebViewResourceRegistry48()

    private val cleanupManager =
        AzerWebViewCleanupManager48()

    private val validator =
        AzerWebViewCleanupValidator48()

    private val logs =
        mutableListOf<AzerWebViewCleanupLog48>()

    fun register(
        id: String,
        webView: WebView
    ) {
        if (!validator.isValidId(id)) return

        registry.register(id, webView)
    }

    fun cleanup(id: String): AzerWebViewCleanupResult48 {
        val webView = registry.get(id)

        if (webView == null) {
            return AzerWebViewCleanupResult48(
                success = false,
                resourceId = id,
                message = "WebView bulunamadı"
            )
        }

        val result = cleanupManager.cleanup(id, webView)

        if (result.success) {
            registry.remove(id)
        }

        logs.add(
            AzerWebViewCleanupLog48(
                resourceId = id,
                success = result.success,
                message = result.message
            )
        )

        return result
    }

    fun cleanupAll(): List<AzerWebViewCleanupResult48> {
        val ids = registry.getAll().mapIndexed { index, _ ->
            registryIdAt(index)
        }

        return ids.mapNotNull { id ->
            cleanup(id)
        }
    }

    private fun registryIdAt(index: Int): String {
        return registry.getAll().getOrNull(index)?.let {
            "webview_$index"
        } ?: ""
    }

    fun getLogs(): List<AzerWebViewCleanupLog48> {
        return logs.toList()
    }

    fun getRegisteredCount(): Int {
        return registry.size()
    }
}
