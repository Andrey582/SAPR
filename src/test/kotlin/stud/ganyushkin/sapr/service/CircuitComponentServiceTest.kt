package stud.ganyushkin.sapr.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import stud.ganyushkin.sapr.model.CircuitComponent

class CircuitComponentServiceTest {

    private val service = CircuitComponentService()

    @Test
    fun `moveComponent should update coordinates`() {
        val component = CircuitComponent("R1", "RESISTOR", "R1", 10, 15)

        val moved = service.moveComponent(component, 5, -3)

        assertEquals(15, moved.x)
        assertEquals(12, moved.y)
    }

    @Test
    fun `renameComponent should trim label`() {
        val component = CircuitComponent("C1", "CAPACITOR", "C1", 0, 0)

        val renamed = service.renameComponent(component, "  C1-new  ")

        assertEquals("C1-new", renamed.label)
    }

    @Test
    fun `renameComponent should reject blank label`() {
        val component = CircuitComponent("L1", "INDUCTOR", "L1", 0, 0)

        assertThrows(IllegalArgumentException::class.java) {
            service.renameComponent(component, "   ")
        }
    }

    @Test
    fun `renameComponent should reject too long label`() {
        val component = CircuitComponent("D1", "DIODE", "D1", 0, 0)

        assertThrows(IllegalArgumentException::class.java) {
            service.renameComponent(component, "A".repeat(33))
        }
    }
}
