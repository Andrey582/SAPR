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
}
