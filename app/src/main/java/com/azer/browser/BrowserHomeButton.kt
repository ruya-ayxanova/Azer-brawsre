
package com.azer.browser

import android.content.Context

class BrowserHomeButton(
    context: Context,
    onHome: () -> Unit
) : BrowserToolbarButton(
    context,
    "⌂",
    onHome
)
