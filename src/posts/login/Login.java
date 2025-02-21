package posts.login;

import posts.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    public boolean passwordCheck(String email, String inputPassword) {
        String sql = "SELECT password FROM users WHERE email = ?";
        Connection conn = DatabaseConnection.getConnection();
        try  {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getString("password").equals(inputPassword)) {
                    return true;
                }
                else {
                    System.out.println("Password is not correct");
                    return false;
                }
            } else {
                System.out.println("No user found");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
