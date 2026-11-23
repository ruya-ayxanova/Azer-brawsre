package com.azer.browser

data class BrowserSessionResult40(
    val success: Boolean,
    val status: BrowserSessionStatus40,
    val session: BrowserSession40?,
    val message: String = ""
) {

    companion object {

        fun success(
            session: BrowserSession40,
            status: BrowserSessionStatus40,
            message: String = ""
        ) = BrowserSessionResult40(
            success = true,
            status = status,
            session = session,
            message = message
        )

        fun failure(
            message: String
        ) = BrowserSessionResult40(
            success = false,
            status = BrowserSessionStatus40.ERROR,
            session = null,
            message = message
        )
    }
}
