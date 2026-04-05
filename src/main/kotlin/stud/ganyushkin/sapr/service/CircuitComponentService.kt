package stud.ganyushkin.sapr.service

import stud.ganyushkin.sapr.model.CircuitComponent
import stud.ganyushkin.sapr.service.policy.ComponentLabelPolicy

class CircuitComponentService(
    private val labelPolicy: ComponentLabelPolicy = ComponentLabelPolicy { label ->
        label.isNotBlank() && label.length <= 32
    },
) {

    fun moveComponent(component: CircuitComponent, deltaX: Int, deltaY: Int): CircuitComponent =
        component.copy(x = component.x + deltaX, y = component.y + deltaY)

    fun renameComponent(component: CircuitComponent, newLabel: String): CircuitComponent {
        val normalizedLabel = newLabel.trim()
        require(labelPolicy.isAllowed(normalizedLabel)) { "Component label is invalid" }
        return component.copy(label = normalizedLabel)
    }
}
