package dao

import models.FootballClub
import java.sql.Connection
import java.sql.SQLException

class FootballClubDAO(private val connection: Connection) {

    fun getByIdMoreThanTwo(): List<FootballClub> = executeList("SELECT * FROM FOOTBALL_CLUBS WHERE id > 2")

    private fun executeList(sql: String): List<FootballClub> {
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

    fun getSort(): List<FootballClub> = executeList("SELECT * FROM FOOTBALL_CLUBS ORDER BY id DESC;")
}