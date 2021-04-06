package service

import kotlinx.coroutines.*
import model.Person

class PersonService {
    private val data = listOf(
        Person(0, "Ivan", "Ivanov", "ivanov@mail.ru"),
        Person(1, "Petr", "Petrov", "petrov@mail.ru"),
        Person(2, "Semen", "Semenov", "semenov@mail.ru"),
        Person(3, "Fedor", "Fedorov", "fedorov@mail.ru"),
    )

    suspend fun getById(id: Int): Person? {
        delay(100L)
        return data.filter { it.id == id }[0]
    }
}