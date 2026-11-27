class AzerBrowserControlValidator45 {

    fun isValid(request: AzerBrowserControlRequest45): Boolean {
        return when (request.type) {
            AzerBrowserControlType45.SEARCH ->
                !request.value.isNullOrBlank()

            else -> true
        }
    }
}
