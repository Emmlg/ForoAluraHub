package com.emmlg.ForoAluraHub;

import java.sql.Connection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class ForoAluraHubApplication {


	private static final String URL = "jdbc:mysql://localhost:3306/alura_forodb";
	private static final String USER = "root";
	private static final String PASSWORD = "admin2025";

	public static void testConnection() {
		Connection connection = null;
		try {
			// Intentar establecer la conexión
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			if (connection != null) {
				System.out.println("Conexión a MySQL establecida con éxito!");
			}
		} catch (SQLException e) {
			System.err.println("Error al conectar a MySQL: " + e.getMessage());
		} finally {
			// Cerrar la conexión
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException ex) {
				System.err.println("Error al cerrar la conexión: " + ex.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(ForoAluraHubApplication.class, args);


		testConnection();


	}
}