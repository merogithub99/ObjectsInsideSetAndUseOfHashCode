package bcom.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDto {

    String username = "root";
    String password = "admin";
    String url = "jdbc:mysql://localhost:3306/book_works";

    public Connection getConnection() {
        Connection connection = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage()+"failed to connect to the database");
        }
        return connection;
    }
}
