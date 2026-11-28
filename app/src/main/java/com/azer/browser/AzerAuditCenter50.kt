class AzerAuditCenter50 {

    val registry = AzerAuditCheckRegistry50()
    val logger = AzerAuditLogger50()
    val reportBuilder = AzerAuditReportBuilder50()
    val summary = AzerAuditSummary50()
    val stateManager = AzerAuditStateManager50()
    val timeTracker = AzerAuditTimeTracker50()
    val validator = AzerAuditValidator50()
    val formatter = AzerAuditReportFormatter50()

    fun start(): List<AzerAuditItem50> {

        stateManager.setState(AzerAuditState50.RUNNING)
        timeTracker.start()
        logger.add("Audit started")

        val results = mutableListOf<AzerAuditItem50>()

        try {
            for (check in registry.getChecks()) {
                val result = check.execute()
                results.add(result)
                reportBuilder.add(result)
                logger.add("${check.checkName}: ${result.status}")
            }

            timeTracker.finish()
            stateManager.setState(AzerAuditState50.COMPLETED)
            logger.add("Audit completed")

        } catch (e: Exception) {
            timeTracker.finish()
            stateManager.setState(AzerAuditState50.FAILED)
            logger.add("Audit error: ${e.message}")
        }

        return results
    }

    fun getSummary(): AzerAuditResult50 {
        return summary.create(reportBuilder.getItems())
    }

    fun getReport(): String {
        return formatter.format(getSummary())
    }
}
