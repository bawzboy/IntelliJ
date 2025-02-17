package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private PersistUsers users;

    public UserManager() {
        this.users = new PersistUsers();
    }

    public void createUser(UserModel user) {
        UserModel newUser = new UserModel(user);
        String sql = "INSERT INTO users (email, nickname, password) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newUser.getEmail());
            pstmt.setString(2, newUser.getNickname());
            pstmt.setString(3, newUser.getPassword());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void createUser(UserModel user) {
//        UserModel newUser = new UserModel(user);
//        users.getUsers().add(newUser);
//        users.saveUsers();
//    }

    public UserModel readUser(String email) {
        UserModel foundUser = new UserModel();
        String sql = "SELECT * FROM users WHERE email = ?";
        try (Connection conn = DatabaseConnection.connect()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                foundUser.setEmail(rs.getString("email"));
                foundUser.setNickname(rs.getString("nickname"));
                foundUser.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
                e.printStackTrace();
            }
            return foundUser;
    }

//    public UserModel readUser(String email) {
//        for (UserModel user : users.getUsers()) {
//            if (user.getEmail().equals(email)) {
//                return user;
//            }
//        }
//        return null;
//    }


    public List<UserModel> readUsers() {
        List<UserModel> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection conn = DatabaseConnection.connect()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                UserModel foundUser = new UserModel();
                foundUser.setEmail(rs.getString("email"));
                foundUser.setNickname(rs.getString("nickname"));
                foundUser.setPassword(rs.getString("password"));
                users.add(foundUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

//    public List<UserModel> readUsers() {
//        return users.getUsers();
//    }


    public void updateUser(UserModel user) {
        UserModel existingUser = readUser(user.getEmail());
        String sql = "UPDATE users SET nickname = ?, password = ? WHERE email = ?";
        try (Connection conn = DatabaseConnection.connect()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getNickname());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, existingUser.getEmail());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


//        public void updateUser(UserModel user) {
//        UserModel existingUser = readUser(user.getEmail());
//        if (existingUser != null) {
//            existingUser.setNickname(user.getNickname());
//            existingUser.setPassword(user.getPassword());
//        }
//        users.saveUsers();
//    }

    public void deleteUser(String email) {
        UserModel user = readUser(email);
        String sql = "DELETE FROM users WHERE email = ?";
        try (Connection conn = DatabaseConnection.connect()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getEmail());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void deleteUser(String email) {
//        UserModel user = readUser(email);
//        if (user != null) {
//            users.getUsers().remove(readUser(email));
//        }
//        users.saveUsers();
//    }

}
