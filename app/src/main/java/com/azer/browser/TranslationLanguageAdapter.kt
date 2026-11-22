package com.azer.browser

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class TranslationLanguageAdapter(
    context: Context
) : ArrayAdapter<TranslationLanguage>(
    context,
    android.R.layout.simple_spinner_item,
    TranslationLanguageList.languages
) {

    init {
        setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val view = convertView as? TextView
            ?: TextView(context).apply {
                setPadding(16, 12, 16, 12)
                textSize = 16f
            }

        view.text = getItem(position)?.name ?: ""
        return view
    }
}
