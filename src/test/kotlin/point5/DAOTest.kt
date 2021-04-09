package point5

import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DAOTest {

    private val listOfCars = listOf(
        Car(0),
        Car(1),
        Car(2),
        Car(3),
        Car(4)
    )

    fun getAO(): DAO {
        return mockk<DAO> {
            val sl = slot<Int>()
            every { getAll() } returns listOfCars
            every { getById(capture(sl)) } answers {
                when (sl.captured) {
                    in 0..5 -> listOfCars[sl.captured]
                    else -> null
                }
            }
        }
    }

    private val dao = mockk<DAO> {
        val sl = slot<Int>()
        every { getAll() } returns listOfCars
        every { getById(capture(sl)) } answers {
            when (sl.captured) {
                in 0..4 -> listOfCars[sl.captured]
                else -> null
            }
        }
    }

    @Test
    fun getByValidId() {
        val results = mutableListOf<Car>()
        for (i in 0..4) {
            dao.getById(i)?.let { results.add(it) }
        }

        assertAll(
            { for (i in 0..4) verify { dao.getById(i) } },
            { for (i in 0..4) assertEquals(results[i], listOfCars[i]) }
        )
    }

    @Test
    fun getBy5() {
        val id = 5
        val res = dao.getById(id)
        verify(exactly = 1) { dao.getById(id) }
        assertNull(res)
    }

    @Test
    fun getAll() {
        assertEquals(dao.getAll(), listOf(Car(0), Car(1), Car(2), Car(3), Car(4)))
    }
}
