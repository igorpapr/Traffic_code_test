package dao;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static final String URL = "jdbc:mysql://localhost:3306/testsdb";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "qwerty11";

    //get connection object
    public Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
