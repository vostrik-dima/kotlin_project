import dao.FootballClubDAO
import dao.FootballClubSponsorDAO
import dao.PlayerDAO
import dao.SponsorDAO
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
    val sponsorDAO = SponsorDAO(program.connection)
    val fcSpDAO = FootballClubSponsorDAO(program.connection)

    val service = Service()

    //6a
    val playerById = service.findById(playerDAO, 1)

    //6b
    val fcGetByIdMoreThanTwo = service.getByIdMoreThanTwo(fcDAO)

    //6c
    val leftJoin = service.leftJoin(program.connection)
    val join = service.join(program.connection)

    //6d
    val group = service.selectGroup(program.connection)

    //6e
    val sort = service.byIdSort(fcDAO)

    initialization.drop()
    program.close()

}