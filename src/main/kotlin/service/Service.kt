package service

import dao.DAO
import dao.FootballClubDAO
import models.*
import java.sql.Connection
import java.sql.SQLException

class Service {

    //6.a
    fun findById(dao: DAO<Player>, id: Int) = dao.getById(id)
    fun findById(dao: DAO<FootballClub>, id: Int) = dao.getById(id)
    fun findById(dao: DAO<Sponsor>, id: Int) = dao.getById(id)
    fun findById(dao: DAO<FootballClubSponsor>, id: Int) = dao.getById(id)

    //6.b
    fun getByIdMoreThanTwo(dao: FootballClubDAO): List<FootballClub> = dao.getByIdMoreThanTwo()

    //6.c
    fun leftJoin(connection: Connection): List<FCPlayers> {
        val sql =
            "SELECT FOOTBALL_CLUBS.name AS fcName, " +
                    "PLAYERS.name AS playerName, " +
                    "PLAYERS.surname AS playerSurname " +
                    "FROM FOOTBALL_CLUBS " +
                    "LEFT JOIN PLAYERS " +
                    "ON FOOTBALL_CLUBS.id = PLAYERS.footballClubID"
        val statement = connection.createStatement()
        val sponsorList = ArrayList<FCPlayers>()
        try {
            val resultSet = statement.executeQuery(sql)
            while (resultSet.next())
                sponsorList.add(
                    FCPlayers(
                        resultSet.getString("fcName"), resultSet.getString("playerName"),
                        resultSet.getString("playerSurname")
                    )
                )
            return sponsorList
        } catch (e: SQLException) {
            println(e.message)
            return sponsorList
        } finally {
            statement.close()
        }
    }

    fun join(connection: Connection): List<FCSp> {
        val sql =
            "SELECT FOOTBALL_CLUBS.name AS fcName, " +
                    "SPONSORS.name AS spName " +
                    "FROM FCS " +
                    "JOIN FOOTBALL_CLUBS " +
                    "ON FCS.footballClubID = FOOTBALL_CLUBS.id " +
                    "JOIN SPONSORS ON FCS.sponsorID = SPONSORS.id"
        val statement = connection.createStatement()
        val sponsorList = ArrayList<FCSp>()
        return try {
            val resultSet = statement.executeQuery(sql)
            while (resultSet.next())
                sponsorList.add(
                    FCSp(resultSet.getString("fcName"), resultSet.getString("spName"))
                )
            sponsorList
        } catch (e: SQLException) {
            println(e.message)
            sponsorList
        } finally {
            statement.close()
        }
    }

    //6.d
    fun selectGroup(connection: Connection): List<FootballClub> {
        val sql = "SELECT * FROM FOOTBALL_CLUBS GROUP BY country"
        val statement = connection.createStatement()
        val fcList = ArrayList<FootballClub>()
        try {
            val resultSet = statement.executeQuery(sql)
            while (resultSet.next())
                fcList.add(
                    FootballClub(
                        resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("country")
                    )
                )
            return fcList
        } catch (e: SQLException) {
            println(e.message)
            return fcList
        } finally {
            statement.close()
        }
    }

    //6.e
    fun byIdSort(dao: FootballClubDAO): List<FootballClub> = dao.getSort()
}