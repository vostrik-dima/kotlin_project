import service.Service

fun main() {
//    val personDAO = PersonDAO()
//    val catDao = CatDao()

    val service = Service()

    service.zipLists()
    println(service.sortById())
    println(service.groupById())
    println(service.countById(1))
}