class AzerAuditIssueManager50 {

    private val issues = mutableListOf<AzerAuditIssue50>()

    fun add(issue: AzerAuditIssue50) {
        issues.add(issue)
    }

    fun getAll(): List<AzerAuditIssue50> {
        return issues.toList()
    }

    fun getErrors(): List<AzerAuditIssue50> {
        return issues.filter {
            it.severity == AzerAuditStatus50.ERROR
        }
    }

    fun clear() {
        issues.clear()
    }
}
