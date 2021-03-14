package dao

import models.FootballClub
import java.sql.Connection
import java.sql.SQLException

class FootballClubDAO(private val connection: Connection) : DAO<FootballClub> {
    override fun create(footballClub: FootballClub) {
        val sql: String = "INSERT INTO FOOTBALL_CLUBS (id, name, country) VALUES(?, ?, ?)"
        val preparedStatement = connection.prepareStatement(sql)
        preparedStatement.setString(1, footballClub.id.toString())
        preparedStatement.setString(2, footballClub.name)
        preparedStatement.setString(3, footballClub.country)

        try {
            preparedStatement.execute()
            println("Игрок $footballClub добавлен в базу")
        } catch (e: SQLException) {
            println("Ошибка добавления в базу игрока $footballClub")
        } finally {
            preparedStatement.close()
        }
    }

    override fun update(footballClub: FootballClub, id: Int) {
        val sql: String = "UPDATE FOOTBALL_CLUBS SET name=?, country=? WHERE id=?"
        val preparedStatement = connection.prepareStatement(sql)
        preparedStatement.setString(1, footballClub.name)
        preparedStatement.setString(2, footballClub.country)
        preparedStatement.setString(3, footballClub.id.toString())

        try {
            preparedStatement.execute()
            println("Клуб $footballClub обновлен")
        } catch (e: SQLException) {
            println("При обновлении клуба $footballClub возникла ошибка")
        } finally {
            preparedStatement.close()
        }
    }

    override fun delete(id: Int) {
        val sql = "DELETE FROM FOOTBALL_CLUBS WHERE id=?"
        val preparedStatement = connection.prepareStatement(sql)
        preparedStatement.setString(1, id.toString())

        try {
            preparedStatement.execute()
            println("Клуб удален, id: $id")
        } catch (e: SQLException) {
            println("При удалении клуба id: $id возникла ошибка")
        } finally {
            preparedStatement.close()
        }
    }

    override fun getById(id: Int): FootballClub? {
        val sql = "SELECT * FROM FOOTBALL_CLUBS WHERE id = $id"
        val statement = connection.createStatement()

        try {
            val resultSet = statement.executeQuery(sql)
            return if (resultSet.next()) {
                FootballClub(
                    resultSet.getInt("id"), resultSet.getString("name"),
                    resultSet.getString("country")
                )
            } else {
                null
            }
        } catch (e: SQLException) {
            println(e.message)
            return null
        } finally {
            statement.close()
        }
    }

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