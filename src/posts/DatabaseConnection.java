package posts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton-Klasse zur Verwaltung der Datenbankverbindung
 */
class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/posts_db";
    private static final String USER = "root";
    private static final String PASSWORD = "321-Meins";
    private static final Connection connection;

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