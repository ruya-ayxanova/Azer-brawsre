class AzerWebViewCleanupValidator48 {

    fun isValidId(id: String): Boolean {
        return id.isNotBlank()
    }

    fun canCleanup(id: String): Boolean {
        return isValidId(id)
    }
}
