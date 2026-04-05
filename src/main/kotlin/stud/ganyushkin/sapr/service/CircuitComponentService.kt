package stud.ganyushkin.sapr.service

import stud.ganyushkin.sapr.model.CircuitComponent

class CircuitComponentService {

    fun moveComponent(component: CircuitComponent, deltaX: Int, deltaY: Int): CircuitComponent =
        component.copy(x = component.x + deltaX, y = component.y + deltaY)

    fun renameComponent(component: CircuitComponent, newLabel: String): CircuitComponent {
        require(newLabel.isNotBlank()) { "Component label must not be blank" }
        return component.copy(label = newLabel.trim())
    }
}
