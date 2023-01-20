package de.ander.todolist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

	private static final String HOST = "jdbc:mysql://localhost";
	private static final int PORT = 3306; //check mysql port in XAMPP
	private static final String USER = "root";
	private static final String PASSWORD = "";
	private static final String DB_NAME = "20221026todo";
	
	public static Connection getConnection() throws SQLException {
											//DSN (data source name) jdbc:mysql://localhost:3306/20221026_todo
		return DriverManager.getConnection(HOST + ":" + PORT + "/" + DB_NAME, USER, PASSWORD);
	}
}
