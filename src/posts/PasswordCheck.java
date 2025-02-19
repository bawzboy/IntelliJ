package posts;

import user.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswordCheck {
    private static final String URL = "jdbc:mysql://localhost:3306/posts_db";
    private static final String USER = "root";
    private static final String PASSWORD = "321-Meins";

    public boolean check(String email, String inputPassword) {
        String sql = "SELECT password FROM users WHERE email = ?";
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getString("password").equals(inputPassword)) {
                    return true;
                }
                else {
                    System.out.println("Password is not correct");
                }
            } else {
                System.out.println("No user found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}

