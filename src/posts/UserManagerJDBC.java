package posts;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserManagerJDBC implements InterfaceUserManager{

    public void createUser(User user) {
        User newUser = new User(user);
        String sql = "INSERT INTO users (email, name, password, role) VALUES (?, ?, ?, ?)";
        Connection conn = DatabaseConnection.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newUser.getEmail());
            pstmt.setString(2, newUser.getName());
            pstmt.setString(3, newUser.getPasswort());
            pstmt.setString(4, newUser.getRole());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Database error occurred", e);
        }
    }

    public User readUser(String email) {
        User foundUser = new User();
        String sql = "SELECT * FROM users WHERE email = ?";
        Connection conn = DatabaseConnection.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                foundUser.setEmail(rs.getString("email"));
                foundUser.setName(rs.getString("name"));
                foundUser.setPasswort(rs.getString("password"));
                foundUser.setRole(rs.getString("role"));
            } else {
                System.out.println("No user found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundUser;
    }

    public List<User> readUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        Connection conn = DatabaseConnection.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User foundUser = new User();
                foundUser.setEmail(rs.getString("email"));
                foundUser.setName(rs.getString("name"));
                foundUser.setPasswort(rs.getString("password"));
                users.add(foundUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void updateUser(User user) {
        String sql = "UPDATE users SET name = ?, password = ?, role = ? WHERE email = ?";
        Connection conn = DatabaseConnection.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPasswort());
            pstmt.setString(3, user.getRole());
            pstmt.setString(4, user.getEmail());

            if (pstmt.executeUpdate() == 0) {
                throw new RuntimeException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String email) {
        String sql = "DELETE FROM users WHERE email = ?";
        Connection conn = DatabaseConnection.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
