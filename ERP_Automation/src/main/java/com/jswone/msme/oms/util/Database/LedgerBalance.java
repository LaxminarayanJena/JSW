package com.jswone.msme.oms.util.Database;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class LedgerBalance {

	String url = "jdbc:postgresql://34.93.219.164:5432/batua";
	String username = "omsuser";
	String password = "o/?KEvU4?~6T;QMq";
	String gstin = "33AAGCA4932L2ZM";
	public String balance;
 
	public String extractLedgerBalance(String ledgerbalance) {
		try {
			Class.forName("org.postgresql.Driver");

			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to the PostgreSQL database!");
			String selectquery = "select * from entry_rtab  WHERE id = (Select id from (SELECT * FROM entry_rtab WHERE account_id = ( SELECT id FROM account_rtab WHERE category = 'BUYER' AND reference = '33AAGCA4932L2ZM' ) order by when_created desc limit 1) As subquery )";
			PreparedStatement preparedStatement = connection.prepareStatement(selectquery);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				balance = resultSet.getString("balance");
				System.out.println("LedgerBalance: " + balance);
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
		return balance;

	}

	public void updateLedgerBalance(String ledgerBalance) {
	    try {
	        Class.forName("org.postgresql.Driver");
	        Connection connection = DriverManager.getConnection(url, username, password);
	        System.out.println("Connected to the PostgreSQL database!");
	        BigDecimal balanceValue = new BigDecimal(ledgerBalance);
	        String updateQuery = "UPDATE entry_rtab SET balance = ? WHERE id = (SELECT id FROM (SELECT * FROM entry_rtab WHERE account_id = (SELECT id FROM account_rtab WHERE category = 'BUYER' AND reference = '33AAGCA4932L2ZM') ORDER BY when_created DESC LIMIT 1) AS subquery)";
	        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
	        preparedStatement.setBigDecimal(1, balanceValue);
	        int rowsAffected = preparedStatement.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Update successful. Rows affected: " + rowsAffected);
	        } else {
	            System.out.println("No rows were updated.");
	        }
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