package com.azer.browser

object BrowserQrActionResolver {

    fun resolve(result: BrowserQrScanResult): List<BrowserQrAction> {
        if (!result.valid) {
            return listOf(
                BrowserQrAction.COPY_TEXT,
                BrowserQrAction.SHARE,
                BrowserQrAction.CANCEL
            )
        }

        return when (result.type) {
            BrowserQrType.URL -> listOf(
                BrowserQrAction.OPEN_LINK,
                BrowserQrAction.COPY_TEXT,
                BrowserQrAction.SHARE,
                BrowserQrAction.SAVE,
                BrowserQrAction.CANCEL
            )

            else -> listOf(
                BrowserQrAction.COPY_TEXT,
                BrowserQrAction.SHARE,
                BrowserQrAction.SAVE,
                BrowserQrAction.CANCEL
            )
        }
    }
}
