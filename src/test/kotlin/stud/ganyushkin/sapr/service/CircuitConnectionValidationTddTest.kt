package stud.ganyushkin.sapr.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import stud.ganyushkin.sapr.model.CircuitComponent
import stud.ganyushkin.sapr.model.CircuitConnection

class CircuitConnectionValidationTddTest {

    private val service = CircuitAnalysisService()

    @Test
    fun `findInvalidConnectionIds should return empty list for valid connections`() {
        val components = listOf(
            CircuitComponent("R1", "RESISTOR", "R1", 0, 0),
            CircuitComponent("C1", "CAPACITOR", "C1", 10, 0),
        )
        val connections = listOf(
            CircuitConnection("W1", "R1", "C1", "SIG_A"),
        )

        val invalidIds = service.findInvalidConnectionIds(components, connections)

        assertEquals(emptyList<String>(), invalidIds)
    }

    @Test
    fun `findInvalidConnectionIds should return connection with missing source`() {
        val components = listOf(
            CircuitComponent("C1", "CAPACITOR", "C1", 10, 0),
        )
        val connections = listOf(
            CircuitConnection("W1", "R1", "C1", "SIG_A"),
        )

        val invalidIds = service.findInvalidConnectionIds(components, connections)

        assertEquals(listOf("W1"), invalidIds)
    }

    @Test
    fun `findInvalidConnectionIds should return connection with self loop`() {
        val components = listOf(
            CircuitComponent("R1", "RESISTOR", "R1", 0, 0),
        )
        val connections = listOf(
            CircuitConnection("W1", "R1", "R1", "SIG_A"),
        )

        val invalidIds = service.findInvalidConnectionIds(components, connections)

        assertEquals(listOf("W1"), invalidIds)
    }

    @Test
    fun `findInvalidConnectionIds should return connection with blank signal name`() {
        val components = listOf(
            CircuitComponent("R1", "RESISTOR", "R1", 0, 0),
            CircuitComponent("C1", "CAPACITOR", "C1", 10, 0),
        )
        val connections = listOf(
            CircuitConnection("W1", "R1", "C1", "   "),
        )

        val invalidIds = service.findInvalidConnectionIds(components, connections)

        assertEquals(listOf("W1"), invalidIds)
    }
}
