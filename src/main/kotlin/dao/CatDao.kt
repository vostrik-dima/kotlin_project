package dao

import models.Cat

class CatDao(private val cats: List<Cat>) {
    fun getCats(): List<Cat> = cats
    fun getCat(ownerID: Int): Cat? = cats.filter { it.ownerID == ownerID }.getOrNull(0)
}