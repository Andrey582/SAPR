package stud.ganyushkin.sapr.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import stud.ganyushkin.sapr.model.CircuitComponent

class CircuitAssemblyIntegrationTest {

    private val assemblyService = CircuitAssemblyService()

    @Test
    fun `assembleCircuit should integrate component connection and analysis modules`() {
        val source = CircuitComponent("R1", "RESISTOR", "R1", 0, 0)
        val target = CircuitComponent("C1", "CAPACITOR", "C1", 10, 0)

        val result = assemblyService.assembleCircuit(
            source = source,
            target = target,
            sourceLabel = "R1-main",
            connectionId = "W1",
            signalName = "SIG_MAIN",
        )

        assertEquals("R1-main", result.components.first().label)
        assertEquals(1, result.connections.size)
        assertEquals("R1", result.connections.first().sourceComponentId)
        assertEquals("C1", result.connections.first().targetComponentId)
        assertEquals(emptyList<CircuitComponent>(), result.isolatedComponents)
    }

    @Test
    fun `assembleCircuit should keep extra unconnected component isolated`() {
        val source = CircuitComponent("R1", "RESISTOR", "R1", 0, 0)
        val target = CircuitComponent("C1", "CAPACITOR", "C1", 10, 0)
        val extra = CircuitComponent("L1", "INDUCTOR", "L1", 20, 0)

        val result = assemblyService.assembleCircuit(
            source = source,
            target = target,
            sourceLabel = "R1-main",
            connectionId = "W1",
            signalName = "SIG_MAIN",
            additionalComponents = listOf(extra),
        )

        assertEquals(listOf("L1"), result.isolatedComponents.map { it.id })
    }

    @Test
    fun `assembleCircuit should fail on invalid input from lower modules`() {
        val source = CircuitComponent("R1", "RESISTOR", "R1", 0, 0)

        assertThrows(IllegalArgumentException::class.java) {
            assemblyService.assembleCircuit(
                source = source,
                target = source,
                sourceLabel = "   ",
                connectionId = "W1",
                signalName = "SIG_MAIN",
            )
        }
    }
}
