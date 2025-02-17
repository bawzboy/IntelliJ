package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadData {
    private static final String URL = "jdbc:mysql://localhost:3306/user_db";
    private static final String USER = "root";
    private static final String PASSWORD = "321-Meins";

    public static void main(String[] args) {
        String sql = "SELECT * FROM nutzer";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println(id + " | " + name + " | " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
