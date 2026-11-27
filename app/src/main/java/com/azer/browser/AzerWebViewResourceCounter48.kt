import android.webkit.WebView

class AzerWebViewResourceCounter48 {

    fun count(
        webViews: List<WebView>
    ): Int {
        return webViews.size
    }

    fun countLoading(
        webViews: List<WebView>
    ): Int {
        return webViews.count {
            it.progress in 1..99
        }
    }
}
