package service

import java.sql.Connection
import java.sql.SQLException

class Initialization(private val connection: Connection) {

    fun initialization() {
        schema()
        data()
    }

    private fun schema() {

        val statement = connection.createStatement()
        statement.execute("DROP TABLE IF EXISTS FOOTBALL_CLUBS")
        statement.execute("CREATE TABLE FOOTBALL_CLUBS (id INT PRIMARY KEY, name VARCHAR(250), country VARCHAR(250))")
        statement.execute("DROP TABLE IF EXISTS SPONSORS")
        statement.execute("CREATE TABLE SPONSORS (id INT PRIMARY KEY, name VARCHAR(250), budget INT)")
        statement.execute("DROP TABLE IF EXISTS FCS")
        statement.execute("CREATE TABLE FCS (footballClubID INT, sponsorID INT, FOREIGN KEY (footballClubID) REFERENCES FOOTBALL_CLUBS(id), FOREIGN KEY (sponsorID) REFERENCES SPONSORS(id))")
        statement.execute("DROP TABLE IF EXISTS PLAYERS")
        statement.execute("CREATE TABLE PLAYERS (id INT PRIMARY KEY, name VARCHAR(250), surname VARCHAR(250), " +
                "number INT, footballClubID INT, FOREIGN KEY (footballClubID) REFERENCES FOOTBALL_CLUBS(id))")

        statement.close()
    }

    private fun data() {
        //FOOTBALL_CLUBS
        val statement = connection.createStatement()

        statement.execute("INSERT INTO FOOTBALL_CLUBS (id, name, country) VALUES(1, 'Liverpool', 'England')")
        statement.execute("INSERT INTO FOOTBALL_CLUBS (id, name, country) VALUES(2, 'Real Madrid', 'Spain')")
        statement.execute("INSERT INTO FOOTBALL_CLUBS (id, name, country) VALUES(3, 'Monaco', 'France')")
        statement.execute("INSERT INTO FOOTBALL_CLUBS (id, name, country) VALUES(4, 'Chelsea', 'England')")

        //Sponsors
        statement.execute("INSERT INTO SPONSORS (id, name, budget) VALUES(1, 'Nike', 1000000)")
        statement.execute("INSERT INTO SPONSORS (id, name, budget) VALUES(2, 'Jeep', 2000000)")
        statement.execute("INSERT INTO SPONSORS (id, name, budget) VALUES(3, 'yokohama', 1000000)")

        //FCS
        statement.execute("INSERT INTO FCS (footballClubID, sponsorID) VALUES(1, 1)")
        statement.execute("INSERT INTO FCS (footballClubID, sponsorID) VALUES(1, 2)")
        statement.execute("INSERT INTO FCS (footballClubID, sponsorID) VALUES(2, 1)")
        statement.execute("INSERT INTO FCS (footballClubID, sponsorID) VALUES(3, 3)")

        //Players
        statement.execute("INSERT INTO PLAYERS (id, name, surname, number, footballClubID) VALUES(1, 'John', 'Will', 21, 1)")
        statement.execute("INSERT INTO PLAYERS (id, name, surname, number, footballClubID) VALUES(2, 'Sam', 'Mc', 2, 2)")
        statement.close()
    }

    fun drop() {
        with(connection.createStatement()) {
            execute("DROP TABLE IF EXISTS FOOTBALL_CLUBS")
            execute("DROP TABLE IF EXISTS SPONSORS")
            execute("DROP TABLE IF EXISTS FCS")
            execute("DROP TABLE IF EXISTS PLAYERS")
            close()
        }
    }
}