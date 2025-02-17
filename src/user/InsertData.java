package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    private static final String URL = "jdbc:mysql://localhost:3306/user_db";
    private static final String USER = "root";
    private static final String PASSWORD = "321-Meins";

    public static void main(String[] args) {
        String sql = "INSERT INTO nutzer (name, email) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "Max Mustermann");
            pstmt.setString(2, "max@example.com");

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " Datensatz eingefügt.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}