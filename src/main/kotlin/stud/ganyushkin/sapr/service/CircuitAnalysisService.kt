package stud.ganyushkin.sapr.service

import stud.ganyushkin.sapr.model.CircuitComponent
import stud.ganyushkin.sapr.model.CircuitConnection

class CircuitAnalysisService {

    fun countComponentsByType(components: List<CircuitComponent>, type: String): Int =
        components.count { it.type.equals(type, ignoreCase = true) }

    fun findIsolatedComponents(
        components: List<CircuitComponent>,
        connections: List<CircuitConnection>,
    ): List<CircuitComponent> {
        val connectedIds = connections
            .flatMap { listOf(it.sourceComponentId, it.targetComponentId) }
            .toSet()

        return components.filter { it.id !in connectedIds }
    }

    fun findInvalidConnectionIds(
        components: List<CircuitComponent>,
        connections: List<CircuitConnection>,
    ): List<String> {
        val componentIds = components.map { it.id }.toSet()

        return connections
            .filter { connection ->
                connection.sourceComponentId !in componentIds ||
                    connection.targetComponentId !in componentIds ||
                    connection.sourceComponentId == connection.targetComponentId
            }
            .map { it.id }
    }
}
