import service.Service

fun main() {
    val service = Service()

    service.zipLists()
    println(service.sortById())
    println(service.groupById())
    println(service.countById{it.id == 1})
}