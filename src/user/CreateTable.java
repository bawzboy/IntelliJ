package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    private static final String URL = "jdbc:mysql://localhost:3306/user_db";
    private static final String USER = "root";
    private static final String PASSWORD = "321-Meins";

    public static void main(String[] args) {
        String sql = "CREATE TABLE users (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    email VARCHAR(255) NOT NULL UNIQUE,\n" +
                "    nickname VARCHAR(100) NOT NULL,\n" +
                "    password VARCHAR(255) NOT NULL\n" +
                ");";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabelle wurde erstellt.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}