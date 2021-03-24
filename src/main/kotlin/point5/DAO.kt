package point5

interface DAO {
    fun getById(id: Int): Car?
    fun getAll(): List<Car>
}