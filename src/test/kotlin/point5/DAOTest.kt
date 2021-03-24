package point5

import io.mockk.every
import io.mockk.mockkClass
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DAOTest {

    private val dao = mockkClass(DAO::class)

    @Test
    fun getBy3() {
        every { dao.getById(3) } returns Car(3)
        assertEquals(dao.getById(3), Car(3))
    }

    @Test
    fun getBy5() {
        every { dao.getById(5) } returns null
        assertNull(dao.getById(5))
    }

    @Test
    fun getAll() {
        every { dao.getAll() } returns listOf(Car(1), Car(2), Car(3))
        assertEquals(dao.getAll(), listOf(Car(1), Car(2), Car(3)))
    }
}