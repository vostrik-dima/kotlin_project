package service

import java.sql.Connection

class Initialization(private val connection: Connection) {

    fun initialization() {
        schema()
        data()
    }

    private fun schema() {
        var sql = "DROP TABLE IF EXISTS FOOTBALL_CLUBS;"
        val statement = connection.createStatement()
        statement.execute(sql)
        sql = "CREATE TABLE FOOTBALL_CLUBS (id INT PRIMARY KEY, name VARCHAR(250), country VARCHAR(250));"
        statement.execute(sql)

        sql = "DROP TABLE IF EXISTS SPONSORS;"
        statement.execute(sql)
        sql = "CREATE TABLE SPONSORS (id INT PRIMARY KEY, name VARCHAR(250), budget INT);"
        statement.execute(sql)

        sql = "DROP TABLE IF EXISTS FCS;"
        statement.execute(sql)
        sql = "CREATE TABLE FCS (FOREIGN KEY (footballClubID) REFERENCES FOOTBALL_CLUBS," +
                " FOREIGN KEY (sponsorID) REFERENCES SPONSORS);"
        statement.execute(sql)

        sql = "DROP TABLE IF EXISTS PLAYERS;"
        statement.execute(sql)
        sql = "CREATE TABLE PLAYERS (id INT PRIMARY KEY, name VARCHAR(250), surname VARCHAR(250), " +
                "number INT, FOREIGN KEY (footballClubID) REFERENCES FOOTBALL_CLUBS);"
        statement.execute(sql)

        statement.close()
    }

    private fun data() {
        //FOOTBALL_CLUBS
        var sql = "INSERT INTO FOOTBALL_CLUBS (id, name, country) VALUES(1, 'Liverpool', 'England');"
        val statement = connection.createStatement()
        statement.execute(sql)
        sql = "INSERT INTO FOOTBALL_CLUBS (id, name, country) VALUES(2, 'Real Madrid', 'Spain');"
        statement.execute(sql)
        sql = "INSERT INTO FOOTBALL_CLUBS (id, name, country) VALUES(3, 'Monaco', 'France');"
        statement.execute(sql)
        sql = "INSERT INTO FOOTBALL_CLUBS (id, name, country) VALUES(4, 'Chelsea', 'England');"
        statement.execute(sql)

        //Sponsors
        sql = "INSERT INTO SPONSORS (id, name, budget) VALUES(1, 'Nike', 1000000);"
        statement.execute(sql)
        sql = "INSERT INTO SPONSORS (id, name, budget) VALUES(2, 'Jeep', 2000000);"
        statement.execute(sql)
        sql = "INSERT INTO SPONSORS (id, name, budget) VALUES(3, 'yokohama', 1000000);"
        statement.execute(sql)

        //FCS
        sql = "INSERT INTO FCS (footballClubID, sponsorID) VALUES(1, 1);"
        statement.execute(sql)
        sql = "INSERT INTO FCS (footballClubID, sponsorID) VALUES(1, 2);"
        statement.execute(sql)
        sql = "INSERT INTO FCS (footballClubID, sponsorID) VALUES(2, 1);"
        statement.execute(sql)
        sql = "INSERT INTO FCS (footballClubID, sponsorID) VALUES(3, 3);"
        statement.execute(sql)

        //Players
        sql = "INSERT INTO PLAYERS (id, name, surname, number, footballClubID) VALUES(1, 'John', 'Will', 21, 1);"
        statement.execute(sql)
        sql = "INSERT INTO PLAYERS (id, name, surname, number, footballClubID) VALUES(2, 'Sam', 'Mc', 2, 2);"
        statement.execute(sql)
        statement.close()
    }

    fun drop() {
        var sql = "DROP TABLE IF EXISTS FOOTBALL_CLUBS;"
        val statement = connection.createStatement()
        statement.execute(sql)
        sql = "DROP TABLE IF EXISTS SPONSORS;"
        statement.execute(sql)
        sql = "DROP TABLE IF EXISTS FCS;"
        statement.execute(sql)
        sql = "DROP TABLE IF EXISTS PLAYERS;"
        statement.execute(sql)
        statement.close()
    }
}