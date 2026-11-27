import android.webkit.WebView

class AzerWebViewResourceRegistry48 {

    private val items = mutableMapOf<String, WebView>()

    fun register(id: String, webView: WebView) {
        items[id] = webView
    }

    fun get(id: String): WebView? {
        return items[id]
    }

    fun remove(id: String): WebView? {
        return items.remove(id)
    }

    fun getAll(): List<WebView> {
        return items.values.toList()
    }

    fun size(): Int = items.size

    fun clearRegistry() {
        items.clear()
    }
}
