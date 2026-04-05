package stud.ganyushkin.sapr.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import stud.ganyushkin.sapr.model.CircuitComponent

class CircuitConnectionServiceTest {

    private val service = CircuitConnectionService()

    private val source = CircuitComponent("R1", "RESISTOR", "R1", 10, 10)
    private val target = CircuitComponent("C1", "CAPACITOR", "C1", 20, 20)

    @Test
    fun `createConnection should build connection between different components`() {
        val connection = service.createConnection("W1", source, target, "SIG_A")

        assertEquals("R1", connection.sourceComponentId)
        assertEquals("C1", connection.targetComponentId)
        assertEquals("SIG_A", connection.signalName)
    }

    @Test
    fun `createConnection should reject same source and target`() {
        assertThrows(IllegalArgumentException::class.java) {
            service.createConnection("W1", source, source, "SIG_A")
        }
    }
}
