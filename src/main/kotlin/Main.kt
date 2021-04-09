import dao.FootballClubDAO
import dao.PlayerDAO
import service.Initialization
import service.Program
import service.Service

fun main() {

    val program = Program()
    program.open()
    val initialization = Initialization(program.connection)
    initialization.initialization()

    val playerDAO = PlayerDAO(program.connection)
    val fcDAO = FootballClubDAO(program.connection)

    val service = Service(program.connection, fcDAO)

    //6a
    val playerById = service.findById(playerDAO, 1)
    println(playerById)

    //6b
    val fcGetByIdMoreThanTwo = service.getByIdMoreThanTwo()
    println(fcGetByIdMoreThanTwo)

    //6c
    val leftJoin = service.leftJoin()
    println(leftJoin)
    val join = service.join()
    println(join)

    //6d
    val group = service.selectGroup()
    println(group)

    //6e
    val sort = service.byIdSort()
    println(sort)

    initialization.drop()
    program.close()
}