import dao.CatDao
import dao.PersonDAO
import service.Service

fun main() {
    val catDao = CatDao()
    val personDAO = PersonDAO()
    val service = Service(personDAO, catDao)
    val dataList = service.zipLists()
    println(dataList)
    println(service.sortById())
    println(service.groupById())
    println(service.countById { it.id == 1 })
    println(personDAO.getPersons())
    println(personDAO.getPerson(3))
    println(catDao.getCat(2))
}