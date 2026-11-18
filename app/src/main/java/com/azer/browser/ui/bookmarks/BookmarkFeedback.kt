package com.azer.browser.ui.bookmarks

import android.content.Context
import android.widget.Toast

object BookmarkFeedback {

    fun show(context: Context, result: BookmarkToggleResult) {
        val message = when (result) {
            BookmarkToggleResult.ADDED ->
                "Yer imlerine eklendi"

            BookmarkToggleResult.REMOVED ->
                "Yer imi kaldırıldı"

            BookmarkToggleResult.ALREADY_EXISTS ->
                "Bu sayfa zaten kayıtlı"

            BookmarkToggleResult.INVALID_URL ->
                "Bu sayfa kaydedilemez"

            BookmarkToggleResult.FAILED ->
                "İşlem başarısız"
        }

        Toast.makeText(
            context,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }
}
