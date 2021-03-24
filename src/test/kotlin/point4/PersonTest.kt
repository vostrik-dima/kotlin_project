package point4

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PersonTest {

    @Test
    fun dsl() {
        val person = mockk<Person>() {
            every { name } returns "John"
            every { age } returns 25
            every { getPerson() } returns "John, age: 25"
        }

        assertAll("Test person mockk",
            { assertEquals("John", person.name)},
            { assertEquals(25, person.age)},
            { assertEquals("John, age: 25", person.getPerson())}
        )
    }
}

