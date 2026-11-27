class AzerBrowserDiagnosticFormatter46 {

    fun format(
        diagnostic: AzerBrowserDiagnostic46
    ): String {

        return buildString {
            appendLine("Azer Browser sistem kontrolü")
            appendLine("----------------------------")
            appendLine(
                "Hazır: ${diagnostic.health.isReady}"
            )
            appendLine(
                "Bağlantı: ${diagnostic.connection}"
            )
            appendLine(
                "Aktif sekme: ${diagnostic.runtime.activeTabCount}"
            )
            appendLine(
                "İşlem sayısı: ${diagnostic.runtime.totalOperations}"
            )
            appendLine(
                "Hata sayısı: ${diagnostic.runtime.errorCount}"
            )

            if (diagnostic.health.hasError) {
                appendLine(
                    "Hata: ${diagnostic.health.errorMessage}"
                )
            }
        }
    }
}
