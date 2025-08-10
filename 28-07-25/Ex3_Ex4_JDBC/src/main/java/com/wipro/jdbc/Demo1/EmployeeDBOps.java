package com.wipro.jdbc.Demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDBOps {
	public static void main(String[] args) {
        insertEmployee(25, "Vedant", "Data Analytics");
        readEmployeeData();
    }

    public static void insertEmployee(int id, String name, String department) {
        String url = "jdbc:mysql://localhost:3306/employeedb";
        String user = "root";
        String password = "rutika";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "INSERT INTO employee(id, name, department) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, department);

            int rows = stmt.executeUpdate();
            System.out.println(rows + " Record inserted");

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readEmployeeData() {
        String url = "jdbc:mysql://localhost:3306/employeedb";
        String user = "root";
        String password = "rutika";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM employee";

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");

                System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
