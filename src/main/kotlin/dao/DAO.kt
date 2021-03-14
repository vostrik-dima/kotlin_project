package dao

interface DAO<T> {
    fun create(t: T)
    fun update(t: T, id: Int)
    fun delete(id: Int)
    fun getById(id: Int): T?
}