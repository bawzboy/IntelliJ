package posts;

import java.sql.*;

public class ReadData {
    private static final String URL = "jdbc:mysql://localhost:3306/posts_db";
    private static final String USER = "root";
    private static final String PASSWORD = "321-Meins";

    public static void main(String[] args) {
        String sql = "SELECT * FROM users";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                System.out.println(id + " | " + email + " | " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
