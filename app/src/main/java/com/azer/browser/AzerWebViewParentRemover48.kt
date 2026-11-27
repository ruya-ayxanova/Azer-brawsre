import android.view.ViewGroup
import android.webkit.WebView

class AzerWebViewParentRemover48 {

    fun remove(webView: WebView) {
        val parent = webView.parent

        if (parent is ViewGroup) {
            parent.removeView(webView)
        }
    }
}
