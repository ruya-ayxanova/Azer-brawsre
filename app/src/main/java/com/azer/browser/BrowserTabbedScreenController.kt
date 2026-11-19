
package com.azer.browser

import android.content.Context
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout

class BrowserTabbedScreenController(
    context: Context
) : BrowserTabListener, TabWebViewCallbacks {

    private val tabContainer = FrameLayout(context)

    val root = LinearLayout(context).apply {
        orientation = LinearLayout.VERTICAL
    }

    val tabController = BrowserTabController(
        context,
        this
    )

    private val repository = TabWebViewRepository(
        context,
        tabContainer,
        this
    )

    private val navigator = TabWebViewNavigator(repository)

    init {
        root.addView(
            tabController.view,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )

        root.addView(
            tabContainer,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        tabController.getCurrentTab()?.let {
            onTabSelected(it)
        }
    }

    override fun onTabSelected(tab: BrowserTab) {
        val existing = repository.find(tab.id)

        repository.show(tab.id)

        if (existing == null && tab.url.isNotBlank()) {
            navigator.loadUrl(tab.id, tab.url)
        }
    }

    override fun onTabClosed(tab: BrowserTab) {
        repository.remove(tab.id)
    }

    override fun onNewTabRequested() {
        tabController.createNewTab()
    }

    override fun onPageStarted(tabId: String, url: String) {
        updateTabIfActive(tabId, url = url)
    }

    override fun onPageFinished(tabId: String, url: String) {
        updateTabIfActive(tabId, url = url)
    }

    override fun onPageTitleChanged(tabId: String, title: String) {
        updateTabIfActive(tabId, title = title)
    }

    override fun onPageProgress(tabId: String, progress: Int) {
        // İlerleme göstergesi sonraki aşamada arayüze bağlanacak.
    }

    private fun updateTabIfActive(
        tabId: String,
        title: String? = null,
        url: String? = null
    ) {
        val current = tabController.getCurrentTab() ?: return

        if (current.id != tabId) return

        tabController.updateCurrentTab(
            title ?: current.title,
            url ?: navigator.getCurrentUrl(tabId) ?: current.url
        )
    }

    fun openUrl(url: String) {
        val tab = tabController.getCurrentTab() ?: return
        navigator.loadUrl(tab.id, url)
    }

    fun goBack(): Boolean {
        val tab = tabController.getCurrentTab() ?: return false
        return navigator.goBack(tab.id)
    }

    fun goForward(): Boolean {
        val tab = tabController.getCurrentTab() ?: return false
        return navigator.goForward(tab.id)
    }

    fun reload() {
        val tab = tabController.getCurrentTab() ?: return
        navigator.reload(tab.id)
    }

    fun onPause() {
        tabController.getCurrentTab()?.let {
            navigator.getWebView(it.id)?.onPause()
        }
    }

    fun onResume() {
        tabController.getCurrentTab()?.let {
            navigator.getWebView(it.id)?.onResume()
        }
    }

    fun destroy() {
        repository.destroyAll()
    }
}
