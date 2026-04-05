package stud.ganyushkin.sapr.service.policy

import stud.ganyushkin.sapr.model.CircuitComponent

fun interface ConnectionPolicy {
    fun isAllowed(source: CircuitComponent, target: CircuitComponent): Boolean
}
