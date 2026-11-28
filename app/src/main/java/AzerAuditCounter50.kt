class AzerAuditCounter50 {

    fun countPassed(items: List<AzerAuditItem50>): Int {
        return items.count {
            it.status == AzerAuditStatus50.READY
        }
    }

    fun countWarnings(items: List<AzerAuditItem50>): Int {
        return items.count {
            it.status == AzerAuditStatus50.WARNING
        }
    }

    fun countErrors(items: List<AzerAuditItem50>): Int {
        return items.count {
            it.status == AzerAuditStatus50.ERROR
        }
    }
}
