package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Testdb {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/demo";
        String username = "root";
        String pass = "admin";

        String sql = "INSERT INTO t1(name, password) VALUES('ram', '123')";

        try (Connection connection = DriverManager.getConnection(url, username, pass);
             Statement statement = connection.createStatement()) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            int rowsAffected = statement.executeUpdate(sql);

            if (rowsAffected > 0) {
                System.out.println("Insert successful!");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL exception occurred.");
            e.printStackTrace();
        }
    }
}
