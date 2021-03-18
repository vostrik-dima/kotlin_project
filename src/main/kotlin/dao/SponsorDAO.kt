package dao

import models.Sponsor
import java.sql.Connection
import java.sql.SQLException

class SponsorDAO(private val connection: Connection) : DAO<Sponsor> {
    override fun create(sponsor: Sponsor) {
        val sql: String = "INSERT INTO SPONSORS (id, name, country) VALUES(?, ?, ?)"
        val preparedStatement = connection.prepareStatement(sql)
        preparedStatement.setString(1, sponsor.id.toString())
        preparedStatement.setString(2, sponsor.name)
        preparedStatement.setString(3, sponsor.budget.toString())

        try {
            preparedStatement.execute()
            println("Игрок $sponsor добавлен в базу")
        } catch (e: SQLException) {
            println("Ошибка добавления в базу игрока $sponsor")
        } finally {
            preparedStatement.close()
        }
    }

    override fun update(sponsor: Sponsor, id: Int) {
        val sql: String = "UPDATE SPONSORS SET name=?, budget=? WHERE id=?"
        val preparedStatement = connection.prepareStatement(sql)
        preparedStatement.setString(1, sponsor.name)
        preparedStatement.setString(2, sponsor.budget.toString())
        preparedStatement.setString(3, sponsor.id.toString())

        try {
            preparedStatement.execute()
            println("Спонсор $sponsor обновлен")
        } catch (e: SQLException) {
            println("При обновлении спонсора $sponsor возникла ошибка")
        } finally {
            preparedStatement.close()
        }
    }

    override fun delete(id: Int) {
        val sql = "DELETE FROM SPONSORS WHERE id=?"
        val preparedStatement = connection.prepareStatement(sql)
        preparedStatement.setString(1, id.toString())

        try {
            preparedStatement.execute()
            println("Спонсор удален, id: $id")
        } catch (e: SQLException) {
            println("При удалении спонсора id: $id возникла ошибка")
        } finally {
            preparedStatement.close()
        }
    }

    override fun getById(id: Int): Sponsor? {
        val sql = "SELECT * FROM SPONSORS WHERE id = ?"
        val preparedStatement = connection.prepareStatement(sql)
        preparedStatement.setString(1, id.toString())

        try {
            val resultSet = preparedStatement.executeQuery()
            return if (resultSet.next()) {
                Sponsor(
                    resultSet.getInt("id"), resultSet.getString("name"),
                    resultSet.getInt("budget")
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

    fun getByIdMoreThanTwo(): List<Sponsor> = executeList("SELECT * FROM SPONSORS WHERE id > 2")

    private fun executeList(sql: String): List<Sponsor> {
        val statement = connection.createStatement()
        val sponsorList = ArrayList<Sponsor>()
        try {
            val resultSet = statement.executeQuery(sql)
            while (resultSet.next())
                sponsorList.add(
                    Sponsor(
                        resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getInt("budget")
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

    fun getSort(): List<Sponsor> =executeList("SELECT * FROM SPONSORS ORDER BY id DESC;")
}