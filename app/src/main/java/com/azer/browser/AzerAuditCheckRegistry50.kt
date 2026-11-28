class AzerAuditCheckRegistry50 {

    private val checks = mutableListOf<AzerAuditCheck50>()

    fun register(check: AzerAuditCheck50) {
        checks.add(check)
    }

    fun getChecks(): List<AzerAuditCheck50> {
        return checks.toList()
    }

    fun clear() {
        checks.clear()
    }

    fun size(): Int {
        return checks.size
    }
}
