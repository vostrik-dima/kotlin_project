import dao.PlayerDAO
import models.Player
import service.Initialization
import service.Program

fun main() {

//    try {
//        val connection = DriverManager.getConnection("jdbc:sqlite:football.db")
//        println("Connected")
//    }
//    catch (e: SQLException) {
//        println(e.message)
//    }

    val program = Program()
    program.open()
    val initialization = Initialization()
    initialization.initialization(program.connection)

    val playerDAO = PlayerDAO(program.connection)

    val player = Player(3, "Don", "Paul", 3, 2)

    playerDAO.create(player)

//    playerDAO.getById(2)
    val pl = playerDAO.getById(2)

    initialization.drop(program.connection)
    program.close()

}