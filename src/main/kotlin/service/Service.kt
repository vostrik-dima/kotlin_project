package service

import models.Cat
import models.Person
import models.PersonWithCat

class Service {

    lateinit var personWithCat: List<PersonWithCat>

    // пункт 5a
    fun zipLists(persons: List<Person>, cats: List<Cat>) {
        personWithCat = persons.zip(cats) {p, c -> PersonWithCat(p.id, p.name, p.age, c.nickname, c.breed, c.ownerID) }
    }

    //пункт 5b
    fun sortById(): List<PersonWithCat> = personWithCat.sortedBy { it.id }

    //пункт 5c
    fun groupById(): Map<Int, List<PersonWithCat>> = personWithCat.groupBy { it.id }

    //пункт 5d
    fun countById(id: Int): Int = personWithCat.count { it.id == id }
}