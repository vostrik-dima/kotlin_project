import dao.CatDao
import dao.PersonDAO
import service.Service

fun main() {
    val service = Service()
    service.zipLists()
    println(service.sortById())
    println(service.groupById())
    println(service.countById { it.id == 1 })

    val personDAO = PersonDAO()
    println(personDAO.getPersons())
    println(personDAO.getPerson(3))
    val catDao = CatDao()
    println(catDao.getCat(2))
}