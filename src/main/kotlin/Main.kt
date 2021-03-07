import dao.CatDao
import dao.PersonDAO
import service.Service

fun main() {
    val personDAO = PersonDAO()
    val catDao = CatDao()

    val service = Service()

    service.zipLists(personDAO.getPersons(), catDao.getCats())
    println(service.sortById())
    println(service.groupById())
    println(service.countById(1))
}