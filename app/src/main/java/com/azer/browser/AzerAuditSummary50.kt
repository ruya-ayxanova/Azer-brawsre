class AzerAuditSummary50 {

    fun create(items: List<AzerAuditItem50>): AzerAuditResult50 {

        val passed = items.count {
            it.status == AzerAuditStatus50.READY
        }

        val warnings = items.count {
            it.status == AzerAuditStatus50.WARNING
        }

        val errors = items.count {
            it.status == AzerAuditStatus50.ERROR
        }

        val status = when {
            errors > 0 -> AzerAuditStatus50.ERROR
            warnings > 0 -> AzerAuditStatus50.WARNING
            else -> AzerAuditStatus50.READY
        }

        return AzerAuditResult50(
            status = status,
            totalChecks = items.size,
            passed = passed,
            warnings = warnings,
            errors = errors
        )
    }
}
