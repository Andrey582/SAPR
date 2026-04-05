package stud.ganyushkin.sapr.service

import stud.ganyushkin.sapr.model.CircuitComponent
import stud.ganyushkin.sapr.model.CircuitConnection

class CircuitConnectionService {

    fun createConnection(
        id: String,
        source: CircuitComponent,
        target: CircuitComponent,
        signalName: String,
    ): CircuitConnection {
        require(source.id != target.id) { "Connection must link different components" }
        require(signalName.isNotBlank()) { "Signal name must not be blank" }

        return CircuitConnection(
            id = id,
            sourceComponentId = source.id,
            targetComponentId = target.id,
            signalName = signalName.trim(),
        )
    }
}
