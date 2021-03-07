package dao

import models.Cat

class CatDao() {

    private val cats: List<Cat> = listOf(
        Cat("пушок", "манчикин", 1),
        Cat("царапка", "сиамский", 2)
    )

    fun getCats(): List<Cat> = cats
    fun getCat(ownerID: Int): Cat? = cats.filter { it.ownerID == ownerID }.getOrNull(0)
}