
package com.azer.browser

import android.app.Activity
import android.os.Bundle
import android.webkit.*
import android.widget.*
import android.view.ViewGroup
import android.graphics.Color
import android.app.DownloadManager
import android.net.Uri
import android.os.Environment

class MainActivity : Activity() {

    private lateinit var webView: WebView
    private lateinit var addressBar: EditText
    private lateinit var downloadManager: DownloadManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        downloadManager =
            getSystemService(DOWNLOAD_SERVICE) as DownloadManager

        val root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL

        addressBar = EditText(this)
        addressBar.hint = "Adres veya arama yaz"
        addressBar.singleLine = true

        val buttons = LinearLayout(this)
        buttons.orientation = LinearLayout.HORIZONTAL

        fun addButton(name: String, action: () -> Unit) {
            val button = Button(this)
            button.text = name
            button.setOnClickListener { action() }
            buttons.addView(
                button,
                LinearLayout.LayoutParams(0, 55, 1f)
            )
        }

        addButton("Geri") {
            if (webView.canGoBack()) webView.goBack()
        }

        addButton("İleri") {
            if (webView.canGoForward()) webView.goForward()
        }

        addButton("Yenile") {
            webView.reload()
        }

        addButton("Ana sayfa") {
            webView.loadUrl("https://www.google.com")
        }

        webView = WebView(this)

        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.loadsImagesAutomatically = true

        webView.webViewClient = WebViewClient()

        webView.webChromeClient = WebChromeClient()

        webView.setDownloadListener {
                url, userAgent, contentDisposition,
                mimeType, contentLength ->

            val request = DownloadManager.Request(Uri.parse(url))
            request.setMimeType(mimeType)
            request.addRequestHeader("User-Agent", userAgent)
            request.setTitle(
                URLUtil.guessFileName(
                    url,
                    contentDisposition,
                    mimeType
                )
            )
            request.setNotificationVisibility(
                DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED
            )
            request.setDestinationInExternalPublicDir(
                Environment.DIRECTORY_DOWNLOADS,
                URLUtil.guessFileName(
                    url,
                    contentDisposition,
                    mimeType
                )
            )

            downloadManager.enqueue(request)
        }

        val go = Button(this)
        go.text = "Git"
        go.setOnClickListener {
            openWebsite(addressBar.text.toString())
        }

        root.addView(addressBar)
        root.addView(go)
        root.addView(buttons)

        root.addView(
            webView,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        setContentView(root)

        webView.loadUrl("https://www.google.com")
    }

    private fun openWebsite(input: String) {
        val url = if (
            input.startsWith("https://") ||
            input.startsWith("http://")
        ) {
            input
        } else if (input.contains(".") && !input.contains(" ")) {
            "https://$input"
        } else {
            "https://www.google.com/search?q=" +
                Uri.encode(input)
        }

        webView.loadUrl(url)
    }

    override fun onBackPressed() {
        if (::webView.isInitialized && webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
