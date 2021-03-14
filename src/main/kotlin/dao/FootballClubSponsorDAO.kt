package dao

import models.FootballClubSponsor
import java.sql.Connection
import java.sql.SQLException

class FootballClubSponsorDAO(private val connection: Connection) : DAO<FootballClubSponsor> {
    override fun create(fcs: FootballClubSponsor) {
        val sql: String = "INSERT INTO FCS (footballClubID, sponsorID) VALUES(?, ?)"
        val preparedStatement = connection.prepareStatement(sql)
        preparedStatement.setString(1, fcs.footballClubID.toString())
        preparedStatement.setString(2, fcs.sponsorID.toString())

        try {
            preparedStatement.execute()
            println("Связь клуба со спонсором добавлена в базу")
        } catch (e: SQLException) {
            println("Ошибка добавления в базу связи клуба со спонсором")
        } finally {
            preparedStatement.close()
        }
    }

    override fun update(fcs: FootballClubSponsor, id: Int) {
        val sql: String = "UPDATE FCS SET sponsorID=? WHERE footballClubID=?"
        val preparedStatement = connection.prepareStatement(sql)
        preparedStatement.setString(1, fcs.sponsorID.toString())
        preparedStatement.setString(2, fcs.footballClubID.toString())

        try {
            preparedStatement.execute()
            println("Связь обновлена")
        } catch (e: SQLException) {
            println("При обновлении связи возникла ошибка")
        } finally {
            preparedStatement.close()
        }
    }

    override fun delete(id: Int) {
        val sql = "DELETE FROM FCS WHERE id=?"
        val preparedStatement = connection.prepareStatement(sql)
        preparedStatement.setString(1, id.toString())

        try {
            preparedStatement.execute()
            println("Связь удалена")
        } catch (e: SQLException) {
            println("При удалении связи возникла ошибка")
        } finally {
            preparedStatement.close()
        }
    }

    override fun getById(id: Int): FootballClubSponsor? {
        val sql = "SELECT * FROM FCS WHERE id = $id"
        val statement = connection.createStatement()

        return try {
            val resultSet = statement.executeQuery(sql)
            if (resultSet.next()) {
                FootballClubSponsor(resultSet.getInt("footballClubID"), resultSet.getInt("sponsorID"))
            } else {
                null
            }
        } catch (e: SQLException) {
            println(e.message)
            null
        } finally {
            statement.close()
        }
    }

    override fun getByIdMoreThanTwo(): List<FootballClubSponsor> = executeList("SELECT * FROM FCS WHERE id > 2")
//        val sql = "SELECT * FROM FCS WHERE id > 2"
//        val statement = connection.createStatement()
//        val sponsorList = ArrayList<FootballClubSponsor>()
//        try {
//            val resultSet = statement.executeQuery(sql)
//            while (resultSet.next())
//                sponsorList.add(
//                    FootballClubSponsor(
//                        resultSet.getInt("footballClubID"),
//                        resultSet.getInt("sponsorID")
//                    )
//                )
//            return sponsorList
//        } catch (e: SQLException) {
//            println(e.message)
//            return sponsorList
//        } finally {
//            statement.close()
//        }
//    }

    private fun executeList(sql: String): List<FootballClubSponsor> {
        val statement = connection.createStatement()
        val sponsorList = ArrayList<FootballClubSponsor>()
        try {
            val resultSet = statement.executeQuery(sql)
            while (resultSet.next())
                sponsorList.add(
                    FootballClubSponsor(
                        resultSet.getInt("footballClubID"),
                        resultSet.getInt("sponsorID")
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

    override fun getSort(): List<FootballClubSponsor> = executeList("SELECT * FROM FCS WHERE ORDER BY id DESC;")
//        val sql = "SELECT * FROM FCS WHERE ORDER BY id DESC;"
//        val statement = connection.createStatement()
//        val sponsorList = ArrayList<FootballClubSponsor>()
//        try {
//            val resultSet = statement.executeQuery(sql)
//            while (resultSet.next())
//                sponsorList.add(
//                    FootballClubSponsor(
//                        resultSet.getInt("footballClubID"),
//                        resultSet.getInt("sponsorID")
//                    )
//                )
//            return sponsorList
//        } catch (e: SQLException) {
//            println(e.message)
//            return sponsorList
//        } finally {
//            statement.close()
//        }
//    }


}