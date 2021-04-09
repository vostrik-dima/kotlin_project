package service

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class Program {

    lateinit var connection: Connection

    fun open() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:football.db")
            println("Connected")
        }
        catch (e: SQLException) {
            println(e.message)
        }
    }

    fun close() = try {
        connection.close()
        println("Close connection")
    }
    catch (e: SQLException) {
        println(e.message)
    }
}