package dao

import models.Player
import java.sql.Connection
import java.sql.SQLException

class PlayerDAO(private val connection: Connection) {

    fun getById(id: Int): Player? {
        val sql = "SELECT * FROM PLAYERS WHERE id = ?;"
        val preparedStatement = connection.prepareStatement(sql).apply {
            setInt(1, id)
        }

        try {
            val resultSet = preparedStatement.executeQuery()
            return if (resultSet.next()) {
                Player(
                    resultSet.getInt("id"), resultSet.getString("name"),
                    resultSet.getString("surname"), resultSet.getInt("number"),
                    resultSet.getInt("footballClubID")
                )
            } else {
                null
            }
        } catch (e: SQLException) {
            println(e.message)
            return null
        } finally {
            preparedStatement.close()
        }
    }
}