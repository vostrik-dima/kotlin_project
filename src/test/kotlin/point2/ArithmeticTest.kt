package point2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ArithmeticTest {

    private val arithmetic: Arithmetic = Arithmetic()

    @Test
    fun evenTrue() {
        assertTrue(arithmetic.even(24))
    }

    @Test
    fun evenFalse() {
        assertFalse(arithmetic.even(5))
    }

    @Test
    fun multiply25() {
        assertEquals(arithmetic.multiply(5.0, 5.0), 25.0)
    }

    @Test
    fun multiply0() {
        assertEquals(arithmetic.multiply(5.0, 0.0), 0.0)
    }

    @Test
    fun multiply2_5() {
        assertEquals(arithmetic.multiply(1.25, 2.0), 2.5)
    }
}