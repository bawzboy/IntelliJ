package user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//public class DatabaseConnection {
//    private static final String URL = "jdbc:mysql://localhost:3306/user_db";
//    private static final String USER = "root";
//    private static final String PASSWORD = "321-Meins";
//    private static Connection connection;
//
//    public static Connection connect() throws SQLException {
//        return DriverManager.getConnection(URL, USER, PASSWORD);
//    }
//}


/**
 * Singleton-Klasse zur Verwaltung der Datenbankverbindung
 */
class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/user_db";
    private static final String USER = "root";
    private static final String PASSWORD = "321-Meins";
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Fehler bei der Initialisierung der Datenbankverbindung");
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}