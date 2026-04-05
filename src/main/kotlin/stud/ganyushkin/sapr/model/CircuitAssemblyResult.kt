package stud.ganyushkin.sapr.model

data class CircuitAssemblyResult(
    val components: List<CircuitComponent>,
    val connections: List<CircuitConnection>,
    val isolatedComponents: List<CircuitComponent>,
)
