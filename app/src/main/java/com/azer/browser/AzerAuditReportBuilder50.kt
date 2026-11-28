class AzerAuditReportBuilder50 {

    private val items = mutableListOf<AzerAuditItem50>()

    fun add(item: AzerAuditItem50) {
        items.add(item)
    }

    fun getItems(): List<AzerAuditItem50> {
        return items.toList()
    }

    fun clear() {
        items.clear()
    }
}
