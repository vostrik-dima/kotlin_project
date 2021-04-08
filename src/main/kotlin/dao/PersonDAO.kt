package dao

import models.Person

class PersonDAO {

    private val persons: List<Person> = listOf(Person("Боб", 22), Person("Роб", 33))

    fun getPersons(): List<Person> = persons
    fun getPerson(id: Int): Person? = persons.firstOrNull { it.id == id }
}