package posts.db;

import posts.eventBus.EventBus;
import posts.eventBus.InterfaceCallback;
import posts.main.ControllerInterface;
import posts.messages.*;
import posts.rest.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserManagerJDBC implements InterfaceUserManager, InterfaceCallback, ControllerInterface {

    private static UserManagerJDBC userManagerJDBC;

    public static UserManagerJDBC getInstance() {
        if(userManagerJDBC == null) {
            userManagerJDBC = new UserManagerJDBC();
        }
        return userManagerJDBC;
    }

    private UserManagerJDBC() {}

    public void createUser(User user) {
        User newUser = new User(user);
        String sql = "INSERT INTO users (email, name, passwort, nickname) VALUES (?, ?, ?, ?)";
        Connection conn = DatabaseConnection.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newUser.getEmail());
            pstmt.setString(2, newUser.getName());
            pstmt.setString(3, newUser.getPasswort());
            pstmt.setString(4, newUser.getNickname());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Database error occurred", e);
        }
    }

    public User readUser(String email) {
//        User foundUser = null;  // Tests schlagen fehl
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
                foundUser.setPasswort(rs.getString("passwort"));
                foundUser.setNickname(rs.getString("nickname"));
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
                foundUser.setPasswort(rs.getString("passwort"));
                users.add(foundUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void updateUser(User user) {
        String sql = "UPDATE users SET name = ?, passwort = ?, role = ? WHERE email = ?";
        Connection conn = DatabaseConnection.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPasswort());
            pstmt.setString(3, user.getNickname());
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

    @Override
    public void handleMessage(BaseMessage baseMessage) {
        switch (baseMessage.getMessageType()) {
            case "RequestUser":
                RequestUser requestUser = (RequestUser) baseMessage;
                String email = (String) requestUser.getMessageContent();
                try {
                    User user = this.readUser(email);
                    EventBus.getInstance().sendMessage(new ReturnUser(user));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    @Override
    public void init() {
        System.out.println("UserManagerJDBC initialized");
        EventBus.getInstance().registerListener(this);
    }
}
