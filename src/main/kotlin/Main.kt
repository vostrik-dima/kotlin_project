import dao.CatDao
import dao.PersonDAO
import models.Cat
import models.Person

fun main() {

    val d = PersonDAO(listOf(Person("Bob", 22), Person("kot", 33)))

//    println(d.getPerson())

//    val dd = CatDao(listOf(Cat("пушок", Breed.MUNCHKIN, 2),
//        Cat("царапка", Breed.SIAMESE, 1)
//    ))
//    val dd = CatDao(listOf(Cat("пушок", 2),
//        Cat("царапка", 1)
//    ))
//    val result = d.getPersons().ass(dd.getCats()) {}
//
//    println()

    val numbers = listOf("one", "two", "three", "four")
    val result = numbers.associateWith { it.length }

}