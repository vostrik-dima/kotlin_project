package point3

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

internal class ExpansionKtTest {

    @Test
    fun wordCount() {
        assertEquals("shd s".wordCount('s'), 2)
    }

    @Test
    fun wrongChar() {
        assertThrows(IllegalArgumentException::class.java) {
            "shd s".wordCount('c')
        }
    }

}