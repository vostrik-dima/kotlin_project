package service

import dao.CatDao
import dao.PersonDAO
import models.PersonWithCat
import java.util.*

class Service(private val personDAO: PersonDAO, private val catDao: CatDao) {

    private val personWithCat: List<PersonWithCat> = personDAO.getPersons().zip(catDao.getCats()) { person, cat ->
        PersonWithCat(person.id, person.name, person.age, cat.nickname, cat.breed, cat.ownerID)
    }

    // пункт 5a
    fun zipLists(): List<PersonWithCat> = personWithCat

    //пункт 5b
    fun sortById(): List<PersonWithCat> = personWithCat.sortedBy { it.id }

    //пункт 5c
    fun groupById(): Map<Int?, List<PersonWithCat>> = personWithCat.groupBy { it.id }

    //пункт 5d
    fun countById(predicate: (PersonWithCat) -> Boolean): Int = personWithCat.filter(predicate).size
}