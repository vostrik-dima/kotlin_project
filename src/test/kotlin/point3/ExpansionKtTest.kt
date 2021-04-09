package point3

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows

class ExpansionKtTest {

    @Test
    fun wordCount() {
        assertEquals("shd s".wordCount('s'), 2)
    }

    @Test
    fun wrongChar() {
        assertThrows<IllegalArgumentException> {
            "shd s".wordCount('c')
        }
    }
}