package posts;

import user.UserModel;
import java.sql.*;

public class ReadData {

    public static UserModel readData(String email) {
        UserModel foundUser;
        String sql = "SELECT * FROM users WHERE email = ?";
        Connection conn = DatabaseConnection.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                foundUser = new UserModel();
                foundUser.setEmail(rs.getString("email"));
                foundUser.setPassword(rs.getString("password"));
                if (rs.next()) {
                    System.out.println("Multiple users found");
                    return null;
                }
            } else {
                System.out.println("No user found");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return foundUser;
    }
}
