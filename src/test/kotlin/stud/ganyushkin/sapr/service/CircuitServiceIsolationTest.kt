package stud.ganyushkin.sapr.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import stud.ganyushkin.sapr.model.CircuitComponent
import stud.ganyushkin.sapr.service.policy.ComponentLabelPolicy
import stud.ganyushkin.sapr.service.policy.ConnectionPolicy

class CircuitServiceIsolationTest {

    private val component = CircuitComponent("R1", "RESISTOR", "R1", 0, 0)
    private val target = CircuitComponent("C1", "CAPACITOR", "C1", 10, 0)

    @Test
    fun `renameComponent should use stub label policy`() {
        val stubPolicy = ComponentLabelPolicy { label -> label.startsWith("OK-") }
        val service = CircuitComponentService(stubPolicy)

        val renamed = service.renameComponent(component, "OK-R1")

        assertEquals("OK-R1", renamed.label)
    }

    @Test
    fun `renameComponent should fail when mock label policy rejects value`() {
        var capturedLabel: String? = null
        val mockPolicy = ComponentLabelPolicy { label ->
            capturedLabel = label
            false
        }
        val service = CircuitComponentService(mockPolicy)

        assertThrows(IllegalArgumentException::class.java) {
            service.renameComponent(component, "BLOCKED")
        }
        assertEquals("BLOCKED", capturedLabel)
    }

    @Test
    fun `createConnection should fail when stub connection policy blocks pair`() {
        val blockingPolicy = ConnectionPolicy { _, _ -> false }
        val service = CircuitConnectionService(blockingPolicy)

        assertThrows(IllegalArgumentException::class.java) {
            service.createConnection("W1", component, target, "SIG_A")
        }
    }
}
