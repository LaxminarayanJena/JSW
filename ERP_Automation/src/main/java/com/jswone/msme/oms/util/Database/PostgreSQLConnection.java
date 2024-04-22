package com.jswone.msme.oms.util.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgreSQLConnection {
	
	public static void main(String[] args) {
		String url = "jdbc:postgresql://34.93.219.164:5432/postgres";
		String username = "postgres";
		String password = "JSW@qapassword01";
		String gstin = "33AAQCS8000F1ZH";
		try {
			Class.forName("org.postgresql.Driver");

			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to the PostgreSQL database!");

			String query = "SELECT * FROM public.customer_info_rtab WHERE gstin = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, gstin);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String email = resultSet.getString("email");
				System.out.println("Email: " + email);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();

		} catch (ClassNotFoundException e) {
			System.out.println("PostgreSQL JDBC driver not found!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection or query execution failed!");
			e.printStackTrace();
		}
	}
}
