package dao

import models.Player
import java.sql.Connection
import java.sql.SQLException

class PlayerDAO(private val connection: Connection) : DAO<Player> {

    override fun create(player: Player) {
        val sql: String = "INSERT INTO PLAYERS (id, name, surname, number, footballClubID) VALUES(?, ?, ?, ?, ?)"
        val preparedStatement = connection.prepareStatement(sql)
        preparedStatement.setString(1, player.id.toString())
        preparedStatement.setString(2, player.name)
        preparedStatement.setString(3, player.surname)
        preparedStatement.setString(4, player.number.toString())
        preparedStatement.setString(5, player.footballClubID.toString())

        try {
            preparedStatement.execute()
            println("Игрок $player добавлен в базу")
        } catch (e: SQLException) {
            println("Ошибка добавления в базу игрока $player")
        } finally {
            preparedStatement.close()
        }
    }

    override fun update(player: Player, id: Int) {
        val sql: String = "UPDATE PLAYERS SET name=?, surname=?, number=?, footballClubID=? WHERE id=?"
        val preparedStatement = connection.prepareStatement(sql)
        preparedStatement.setString(1, player.name)
        preparedStatement.setString(2, player.surname)
        preparedStatement.setString(3, player.number.toString())
        preparedStatement.setString(4, player.footballClubID.toString())
        preparedStatement.setString(5, player.id.toString())

        try {
            preparedStatement.execute()
            println("Игрок $player обновлен")
        } catch (e: SQLException) {
            println("При обновлении игрока $player возникла ошибка")
        } finally {
            preparedStatement.close()
        }
    }

    override fun delete(id: Int) {
        val sql = "DELETE FROM PLAYERS WHERE id=?;"
        val preparedStatement = connection.prepareStatement(sql)
        preparedStatement.setString(1, id.toString())

        try {
            preparedStatement.execute()
            println("Игрок удален, id: $id")
        } catch (e: SQLException) {
            println("При удалении игрока id: $id возникла ошибка")
        } finally {
            preparedStatement.close()
        }
    }

    override fun getById(id: Int): Player? {
        val sql = "SELECT * FROM PLAYERS WHERE id = $id;"
        val statement = connection.createStatement()

        try {
            val resultSet = statement.executeQuery(sql)
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
            statement.close()
        }
    }

    override fun getByIdMoreThanTwo(): List<Player> = executeList("SELECT * FROM PLAYERS WHERE id > 2;")
//        val sql = "SELECT * FROM PLAYERS WHERE id > 2;"
//        val statement = connection.createStatement()
//        val playerList = ArrayList<Player>()
//        try {
//            val resultSet = statement.executeQuery(sql)
//            while (resultSet.next())
//                playerList.add(
//                    Player(
//                        resultSet.getInt("id"), resultSet.getString("name"),
//                        resultSet.getString("surname"), resultSet.getInt("number"),
//                        resultSet.getInt("footballClubID")
//                    )
//                )
//            return playerList
//        } catch (e: SQLException) {
//            println(e.message)
//            return playerList
//        } finally {
//            statement.close()
//        }
//    }

    private fun executeList(sql: String): List<Player> {
        val statement = connection.createStatement()
        val playerList = ArrayList<Player>()
        try {
            val resultSet = statement.executeQuery(sql)
            while (resultSet.next())
                playerList.add(
                    Player(
                        resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("surname"), resultSet.getInt("number"),
                        resultSet.getInt("footballClubID")
                    )
                )
            return playerList
        } catch (e: SQLException) {
            println(e.message)
            return playerList
        } finally {
            statement.close()
        }
    }

    override fun getSort(): List<Player> = executeList("SELECT * FROM PLAYERS ORDER BY id DESC;")
//        val sql = "SELECT * FROM PLAYERS ORDER BY id DESC;"
//        val statement = connection.createStatement()
//        val playerList = ArrayList<Player>()
//        try {
//            val resultSet = statement.executeQuery(sql)
//            while (resultSet.next())
//                playerList.add(
//                    Player(
//                        resultSet.getInt("id"), resultSet.getString("name"),
//                        resultSet.getString("surname"), resultSet.getInt("number"),
//                        resultSet.getInt("footballClubID")
//                    )
//                )
//            return playerList
//        } catch (e: SQLException) {
//            println(e.message)
//            return playerList
//        } finally {
//            statement.close()
//        }
//    }
}