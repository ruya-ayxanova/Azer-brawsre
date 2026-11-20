
package com.azer.browser

import android.content.Context
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

object BookmarkDialogHelper {

    fun showBookmarkDialog(
        context: Context,
        title: String,
        initialTitle: String = "",
        initialUrl: String = "",
        onSave: (String, String) -> Unit
    ) {
        val titleInput = EditText(context).apply {
            hint = "Yer imi adı"
            setText(initialTitle)
        }

        val urlInput = EditText(context).apply {
            hint = "https://example.com"
            setText(initialUrl)
        }

        val layout = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(24, 8, 24, 8)
            addView(titleInput)
            addView(urlInput)
        }

        AlertDialog.Builder(context)
            .setTitle(title)
            .setView(layout)
            .setNegativeButton("İptal", null)
            .setPositiveButton("Kaydet") { _, _ ->
                val name = titleInput.text.toString().trim()
                val url = urlInput.text.toString().trim()

                if (!BookmarkValidator.isValidTitle(name) ||
                    !BookmarkValidator.isValidUrl(url)) {
                    Toast.makeText(
                        context,
                        "Geçerli bir ad ve HTTP/HTTPS adresi gir.",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    onSave(name, url)
                }
            }
            .show()
    }

    fun showFolderDialog(
        context: Context,
        onSave: (String) -> Unit
    ) {
        val input = EditText(context).apply {
            hint = "Klasör adı"
        }

        AlertDialog.Builder(context)
            .setTitle("Yeni klasör")
            .setView(input)
            .setNegativeButton("İptal", null)
            .setPositiveButton("Oluştur") { _, _ ->
                val name = input.text.toString().trim()

                if (BookmarkValidator.isValidFolderName(name)) {
                    onSave(name)
                } else {
                    Toast.makeText(
                        context,
                        "Klasör adı 1-40 karakter olmalı.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            .show()
    }
}
