package stud.ganyushkin.sapr.service

import stud.ganyushkin.sapr.model.CircuitComponent
import stud.ganyushkin.sapr.model.CircuitConnection
import stud.ganyushkin.sapr.service.policy.ConnectionPolicy

class CircuitConnectionService(
    private val connectionPolicy: ConnectionPolicy = ConnectionPolicy { source, target ->
        source.id != target.id
    },
) {

    fun createConnection(
        id: String,
        source: CircuitComponent,
        target: CircuitComponent,
        signalName: String,
    ): CircuitConnection {
        require(id.isNotBlank()) { "Connection id must not be blank" }
        require(connectionPolicy.isAllowed(source, target)) { "Connection is invalid" }
        require(signalName.isNotBlank()) { "Signal name must not be blank" }

        return CircuitConnection(
            id = id.trim(),
            sourceComponentId = source.id,
            targetComponentId = target.id,
            signalName = signalName.trim(),
        )
    }
}
