package stud.ganyushkin.sapr.model

data class CircuitConnection(
    val id: String,
    val sourceComponentId: String,
    val targetComponentId: String,
    val signalName: String,
)
