package stud.ganyushkin.sapr.service

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import stud.ganyushkin.sapr.model.CircuitComponent

class CircuitBlackBoxValidationTest {

    private val componentService = CircuitComponentService()
    private val connectionService = CircuitConnectionService()
    private val source = CircuitComponent("R1", "RESISTOR", "R1", 10, 10)
    private val target = CircuitComponent("C1", "CAPACITOR", "C1", 20, 20)

    @Test
    fun `renameComponent should reject blank label`() {
        assertThrows(IllegalArgumentException::class.java) {
            componentService.renameComponent(source, "   ")
        }
    }

    @Test
    fun `renameComponent should reject too long label`() {
        assertThrows(IllegalArgumentException::class.java) {
            componentService.renameComponent(source, "A".repeat(33))
        }
    }

    @Test
    fun `createConnection should reject blank id`() {
        assertThrows(IllegalArgumentException::class.java) {
            connectionService.createConnection("   ", source, target, "SIG_A")
        }
    }

    @Test
    fun `createConnection should reject self connection`() {
        assertThrows(IllegalArgumentException::class.java) {
            connectionService.createConnection("W1", source, source, "SIG_A")
        }
    }

    @Test
    fun `createConnection should reject blank signal name`() {
        assertThrows(IllegalArgumentException::class.java) {
            connectionService.createConnection("W1", source, target, "   ")
        }
    }
}
