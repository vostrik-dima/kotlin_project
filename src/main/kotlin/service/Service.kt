package service

import models.Cat
import models.Person
import models.PersonWithCat

class Service {

    lateinit var personWithCat: List<PersonWithCat>

    fun a(persons: List<Person>, cats: List<Cat>) {
        personWithCat = persons.zip(cats) {p, c -> PersonWithCat(p.id, p.name, p.age, c.nickname, c.breed, c.ownerID) }
    }

    fun b(): List<PersonWithCat> = personWithCat.sortedBy { it.id }

    fun c(): Map<Int, List<PersonWithCat>> = personWithCat.groupBy { it.id }

    fun d() {

    }

}