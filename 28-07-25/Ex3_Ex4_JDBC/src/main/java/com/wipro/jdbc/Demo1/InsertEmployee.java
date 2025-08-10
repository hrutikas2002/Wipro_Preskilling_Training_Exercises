package com.wipro.jdbc.Demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertEmployee {
	public static void main(String[] args) {
		// JDBC credentials
		String url = "jdbc:mysql://localhost:3306/employeedb";
		String user = "root";           
		String password = "rutika";  

		// Student data to insert
		int id= 22;
		String name = "Hrutika";
		String department= "Java Development";

		try {
			Connection conn = DriverManager.getConnection(url, user, password);

			String query = "INSERT INTO employee( id,name,department) VALUES (?, ?, ?)";

			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.setString(2, name);

			stmt.setString(3,department);

			int rows = stmt.executeUpdate();
			System.out.println(rows+" Record inserted");

			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
