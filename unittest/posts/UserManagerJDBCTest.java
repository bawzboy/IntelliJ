package posts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerJDBCTest {
    InterfaceUserManager userManager;

    @BeforeEach
    void initUserManager() {
        userManager = new UserManagerJDBC();
        String sql = "DELETE FROM users";
        Connection conn = DatabaseConnection.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testUserManagerConstructor() {
        assertNotNull(userManager);
    }

    @Test
    void testKeineUserImManagerCheck() {
        List<User> alleUser = userManager.readUsers();
        assertEquals(0, alleUser.size());
    }

    @Test
    void testAddUserAndTestListsize() {
        userManager.createUser(new User("test1@me.com", "test1", "Passw0rd!", "User"));
        List<User> alleUser = userManager.readUsers();
        assertEquals(1, alleUser.size());
    }

    @Test
    void testAdd2UserAndTestListsize() {
        userManager.createUser(new User("test1@me.com", "test1", "Passw0rd!", "User"));
        userManager.createUser(new User("test2@me.com", "test2", "Passw0rd!", "User"));
        List<User> alleUser = userManager.readUsers();
        assertEquals(2, alleUser.size());
    }

    @Test
    void testAddUserAndFindUser() {
        userManager.createUser(new User("helge@me.com", "helge", "Passw0rd!", "Admin"));
        User gefunden = userManager.readUser("helge@me.com");
        assertEquals("helge@me.com", gefunden.getEmail());
        assertEquals("helge", gefunden.getName());
        assertEquals("Passw0rd!", gefunden.getPasswort());
    }

    @Test
    void testExceptionWhenEmailNotUniqe() {
        userManager.createUser(new User("helge@me.com", "helge", "Passw0rd!", "Admin"));
        try {
            userManager.createUser(new User("helge@me.com", "helge", "Passw0rd!", "Admin"));
            fail("user mit gleicher Email nicht erlaubt");
        } catch (RuntimeException e) {

        }
    }

    @Test
    void testAddZweiGleicheUserAndFindUser() {
        userManager.createUser(new User("helge@me.com", "helge", "Passw0rd!", "Admin"));
        userManager.createUser(new User("helge2@me.com", "helge2", "Passw0rd!2", "Admin"));

        List<User> alleUser = userManager.readUsers();
        assertEquals(2, alleUser.size());

        User gefunden = userManager.readUser("helge@me.com");
        assertEquals("helge@me.com", gefunden.getEmail());
        assertEquals("helge", gefunden.getName());
        assertEquals("Passw0rd!", gefunden.getPasswort());
    }

    @Test
    void testAddZweiGleicheUser2AndFindUser() {
        userManager.createUser(new User("helge2@me.com", "helge2", "Passw0rd!2", "Admin"));
        userManager.createUser(new User("helge@me.com", "helge", "Passw0rd!", "Admin"));

        List<User> alleUser = userManager.readUsers();
        assertEquals(2, alleUser.size());

        User gefunden = userManager.readUser("helge@me.com");
        assertEquals("helge@me.com", gefunden.getEmail());
        assertEquals("helge", gefunden.getName());
        assertEquals("Passw0rd!", gefunden.getPasswort());
    }

    @Test
    void testDeleteUser() {
        userManager.createUser(new User("helge@me.com", "helge", "Passw0rd!", "Admin"));

        userManager.deleteUser("helge@me.com");

        List<User> alleUser = userManager.readUsers();
        assertEquals(0, alleUser.size());

    }

    @Test
    void testDeleteUserNotIncluded() {
        userManager.createUser(new User("helge2@me.com", "helge", "Passw0rd!", "Admin"));

        userManager.deleteUser("helge@me.com");

        List<User> alleUser = userManager.readUsers();
        assertEquals(1, alleUser.size());

    }

    @Test
    void testUpdateUser() {
        userManager.createUser(new User("helge@me.com", "helge", "Passw0rd!", "Admin"));

        userManager.updateUser(new User("helge@me.com", "Helge", "superPassw0rd!", "User"));

        List<User> alleUser = userManager.readUsers();
        assertEquals(1, alleUser.size());

        User gefunden = userManager.readUser("helge@me.com");
        assertEquals("helge@me.com", gefunden.getEmail());
        assertEquals("Helge", gefunden.getName());
        assertEquals("superPassw0rd!", gefunden.getPasswort());
        assertEquals("User", gefunden.getRole());
    }

    @Test
    void testUpdateUserNotFound() {
        userManager.createUser(new User("helge@me.com","helge","Passw0rd!", "Admin"));
        try {
            userManager.updateUser(new User("helge2@me.com","Helge", "superPassw0rd!", "Admin"));
            fail("Update User not correct / email not found");
        } catch (RuntimeException e) {

        }
    }

    @Test
    void testUpdateUserExtern() {
        userManager.createUser(new User("helge@me.com", "helge", "Passw0rd!", "Admin"));

        User gefunden2 = userManager.readUser("helge@me.com");
        gefunden2.setEmail("helge2@me.com");

        List<User> alleUser = userManager.readUsers();
        assertEquals(1, alleUser.size());

        User gefunden = userManager.readUser("helge@me.com");

        assertEquals("helge@me.com", gefunden.getEmail());
        assertEquals("helge", gefunden.getName());
        assertEquals("Passw0rd!", gefunden.getPasswort());
    }
}