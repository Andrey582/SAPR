package stud.ganyushkin.sapr.service

import org.springframework.stereotype.Service
import stud.ganyushkin.sapr.api.CircuitSummaryResponse
import stud.ganyushkin.sapr.api.CreateCircuitComponentRequest
import stud.ganyushkin.sapr.api.CreateCircuitConnectionRequest
import stud.ganyushkin.sapr.model.CircuitComponent
import stud.ganyushkin.sapr.model.CircuitConnection

@Service
class CircuitWorkspaceService(
    private val componentService: CircuitComponentService = CircuitComponentService(),
    private val connectionService: CircuitConnectionService = CircuitConnectionService(),
    private val analysisService: CircuitAnalysisService = CircuitAnalysisService(),
) {

    private val components = linkedMapOf<String, CircuitComponent>()
    private val connections = linkedMapOf<String, CircuitConnection>()

    fun reset() {
        components.clear()
        connections.clear()
    }

    fun createComponent(request: CreateCircuitComponentRequest): CircuitComponent {
        require(request.id.isNotBlank()) { "Component id must not be blank" }
        require(request.type.isNotBlank()) { "Component type must not be blank" }
        require(request.id !in components) { "Component with id ${request.id} already exists" }

        val component = CircuitComponent(
            id = request.id.trim(),
            type = request.type.trim(),
            label = request.label,
            x = request.x,
            y = request.y,
        )

        val normalizedComponent = componentService.renameComponent(component, request.label)
        components[normalizedComponent.id] = normalizedComponent
        return normalizedComponent
    }

    fun createConnection(request: CreateCircuitConnectionRequest): CircuitConnection {
        require(request.id !in connections) { "Connection with id ${request.id} already exists" }

        val source = components[request.sourceComponentId]
            ?: throw IllegalArgumentException("Source component not found: ${request.sourceComponentId}")
        val target = components[request.targetComponentId]
            ?: throw IllegalArgumentException("Target component not found: ${request.targetComponentId}")

        val connection = connectionService.createConnection(
            id = request.id,
            source = source,
            target = target,
            signalName = request.signalName,
        )

        connections[connection.id] = connection
        return connection
    }

    fun getSummary(): CircuitSummaryResponse {
        val componentList = components.values.toList()
        val connectionList = connections.values.toList()

        return CircuitSummaryResponse(
            componentCount = componentList.size,
            connectionCount = connectionList.size,
            isolatedComponentIds = analysisService.findIsolatedComponents(componentList, connectionList).map { it.id },
            invalidConnectionIds = analysisService.findInvalidConnectionIds(componentList, connectionList),
        )
    }
}
