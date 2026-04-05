package stud.ganyushkin.sapr.service

import stud.ganyushkin.sapr.model.CircuitAssemblyResult
import stud.ganyushkin.sapr.model.CircuitComponent

class CircuitAssemblyService(
    private val componentService: CircuitComponentService = CircuitComponentService(),
    private val connectionService: CircuitConnectionService = CircuitConnectionService(),
    private val analysisService: CircuitAnalysisService = CircuitAnalysisService(),
) {

    fun assembleCircuit(
        source: CircuitComponent,
        target: CircuitComponent,
        sourceLabel: String,
        connectionId: String,
        signalName: String,
        additionalComponents: List<CircuitComponent> = emptyList(),
    ): CircuitAssemblyResult {
        val renamedSource = componentService.renameComponent(source, sourceLabel)
        val connection = connectionService.createConnection(
            id = connectionId,
            source = renamedSource,
            target = target,
            signalName = signalName,
        )

        val components = listOf(renamedSource, target) + additionalComponents
        val connections = listOf(connection)
        val isolatedComponents = analysisService.findIsolatedComponents(components, connections)

        return CircuitAssemblyResult(
            components = components,
            connections = connections,
            isolatedComponents = isolatedComponents,
        )
    }
}
