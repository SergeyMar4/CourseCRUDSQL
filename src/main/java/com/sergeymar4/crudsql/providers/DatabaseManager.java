package com.sergeymar4.crudsql.providers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            String url = "jdbc:sqlite:src/main/resources/db.sqlite";

            try {
                connection = DriverManager.getConnection(url);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            connection = null;
        }
    }
}
