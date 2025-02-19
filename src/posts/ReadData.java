package posts;

import user.UserModel;
import java.sql.*;

public class ReadData {
    private static final String URL = "jdbc:mysql://localhost:3306/posts_db";
    private static final String USER = "root";
    private static final String PASSWORD = "321-Meins";

    public static UserModel readData(String email) {
        UserModel foundUser = new UserModel();
        String sql = "SELECT * FROM users WHERE email = ?";
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                foundUser.setEmail(rs.getString("email"));
                foundUser.setPassword(rs.getString("password"));
                if (rs.next()) {
                    System.out.println("Multiple users found");
                }
            } else {
                System.out.println("No user found");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundUser;
    }
}
