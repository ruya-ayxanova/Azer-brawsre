
package com.azer.browser

import android.app.Activity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.widget.*
import android.view.View
import android.graphics.Color

class MainActivity : Activity() {

    private lateinit var webView: WebView
    private lateinit var addressBar: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setBackgroundColor(Color.WHITE)

        addressBar = EditText(this)
        addressBar.hint = "Web adresi veya arama"
        addressBar.singleLine = true
        addressBar.setText("https://www.google.com")

        val goButton = Button(this)
        goButton.text = "Git"

        webView = WebView(this)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.cacheMode = WebSettings.LOAD_DEFAULT
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()

        goButton.setOnClickListener {
            openWebsite(addressBar.text.toString())
        }

        layout.addView(addressBar)
        layout.addView(goButton)
        layout.addView(
            webView,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        setContentView(layout)
        webView.loadUrl("https://www.google.com")
    }

    private fun openWebsite(input: String) {
        val url = if (input.startsWith("http://") ||
            input.startsWith("https://")) {
            input
        } else if (input.contains(".") && !input.contains(" ")) {
            "https://$input"
        } else {
            "https://www.google.com/search?q=$input"
        }

        addressBar.setText(url)
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
