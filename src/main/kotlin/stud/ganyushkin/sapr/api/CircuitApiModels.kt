package stud.ganyushkin.sapr.api

data class CreateCircuitComponentRequest(
    val id: String,
    val type: String,
    val label: String,
    val x: Int,
    val y: Int,
)

data class CreateCircuitConnectionRequest(
    val id: String,
    val sourceComponentId: String,
    val targetComponentId: String,
    val signalName: String,
)

data class CircuitSummaryResponse(
    val componentCount: Int,
    val connectionCount: Int,
    val isolatedComponentIds: List<String>,
    val invalidConnectionIds: List<String>,
)
