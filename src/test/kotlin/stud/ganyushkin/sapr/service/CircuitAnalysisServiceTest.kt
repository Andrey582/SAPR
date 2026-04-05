package stud.ganyushkin.sapr.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import stud.ganyushkin.sapr.model.CircuitComponent
import stud.ganyushkin.sapr.model.CircuitConnection

class CircuitAnalysisServiceTest {

    private val service = CircuitAnalysisService()

    @Test
    fun `countComponentsByType should count matching components ignoring case`() {
        val components = listOf(
            CircuitComponent("R1", "RESISTOR", "R1", 0, 0),
            CircuitComponent("R2", "resistor", "R2", 5, 0),
            CircuitComponent("C1", "CAPACITOR", "C1", 10, 0),
        )

        val count = service.countComponentsByType(components, "RESISTOR")

        assertEquals(2, count)
    }

    @Test
    fun `findIsolatedComponents should return components without connections`() {
        val components = listOf(
            CircuitComponent("R1", "RESISTOR", "R1", 0, 0),
            CircuitComponent("C1", "CAPACITOR", "C1", 10, 0),
            CircuitComponent("L1", "INDUCTOR", "L1", 20, 0),
        )
        val connections = listOf(
            CircuitConnection("W1", "R1", "C1", "SIG_A"),
        )

        val isolated = service.findIsolatedComponents(components, connections)

        assertEquals(listOf("L1"), isolated.map { it.id })
    }
}
