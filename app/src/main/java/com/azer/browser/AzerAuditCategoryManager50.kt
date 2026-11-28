class AzerAuditCategoryManager50 {

    fun getAllCategories(): List<AzerAuditCategory50> {
        return AzerAuditCategory50.values().toList()
    }

    fun getCategoryName(
        category: AzerAuditCategory50
    ): String {
        return when (category) {
            AzerAuditCategory50.NAVIGATION -> "Navigation"
            AzerAuditCategory50.WEBVIEW -> "WebView"
            AzerAuditCategory50.TABS -> "Tabs"
            AzerAuditCategory50.DOWNLOADS -> "Downloads"
            AzerAuditCategory50.UI -> "Interface"
            AzerAuditCategory50.SECURITY -> "Security"
            AzerAuditCategory50.LIFECYCLE -> "Lifecycle"
            AzerAuditCategory50.STORAGE -> "Storage"
        }
    }
}
