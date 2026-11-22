package com.azer.browser

object BrowserQrParser {

    fun detectType(value: String): BrowserQrType {
        val text = value.trim()

        return when {
            text.startsWith("https://", true) ||
            text.startsWith("http://", true) ->
                BrowserQrType.URL

            text.startsWith("WIFI:", true) ->
                BrowserQrType.WIFI

            text.startsWith("mailto:", true) ->
                BrowserQrType.EMAIL

            text.startsWith("tel:", true) ->
                BrowserQrType.PHONE

            text.isNotBlank() ->
                BrowserQrType.TEXT

            else ->
                BrowserQrType.UNKNOWN
        }
    }

    fun parse(value: String): BrowserQrScanResult {
        val text = value.trim()
        val type = detectType(text)

        return when (type) {
            BrowserQrType.URL -> BrowserQrScanResult(
                rawValue = text,
                type = type,
                valid = BrowserQrValidator.isValidWebUrl(text),
                url = if (BrowserQrValidator.isValidWebUrl(text)) text else null
            )

            BrowserQrType.UNKNOWN -> BrowserQrScanResult(
                rawValue = text,
                type = type,
                valid = false
            )

            else -> BrowserQrScanResult(
                rawValue = text,
                type = type,
                valid = BrowserQrValidator.isValidContent(text)
            )
        }
    }
}
