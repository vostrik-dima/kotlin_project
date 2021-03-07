package dao

import models.Person

class PersonDAO(private val persons: List<Person>) {
    fun getPersons(): List<Person> = persons
    fun getPerson(id: Int): Person? = persons.filter { it.id == id }.getOrNull(0)
}