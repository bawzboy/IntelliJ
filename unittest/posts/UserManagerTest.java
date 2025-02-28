package posts;

import org.junit.jupiter.api.*;
import posts.archive.UserManager;
import posts.db.InterfaceUserManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {
    InterfaceUserManager userManager;

    @BeforeEach
    void initUserManager() {
        userManager = new UserManager();

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
        userManager.createUser(new User());
        List<User> alleUser = userManager.readUsers();
        assertEquals(1, alleUser.size());
    }

    @Test
    void testAdd2UserAndTestListsize() {
        userManager.createUser(new User());
        userManager.createUser(new User("", "", "", ""));
        List<User> alleUser = userManager.readUsers();
        assertEquals(2, alleUser.size());
    }

    @Test
    void testAddUserAndFindUser() {
        userManager.createUser(new User("helge@me.com", "helge", "passwort", "Admin"));
        User gefunden = userManager.readUser("helge@me.com");
        assertEquals("helge@me.com", gefunden.getEmail());
        assertEquals("helge", gefunden.getName());
        assertEquals("passwort", gefunden.getPasswort());
    }

    @Test
    void testExceptionWhenEmailNotUniqe() {
        userManager.createUser(new User("helge@me.com", "helge", "passwort", "Admin"));
        try {
            userManager.createUser(new User("helge@me.com", "helge", "passwort", "Admin"));
            fail("user mit gleicher Email nicht erlaubt");
        } catch (RuntimeException e) {

        }
    }

    @Test
    void testAddZweiGleicheUserAndFindUser() {
        userManager.createUser(new User("helge@me.com", "helge", "passwort", "Admin"));
        userManager.createUser(new User("helge2@me.com", "helge2", "passwort2", "Admin"));

        List<User> alleUser = userManager.readUsers();
        assertEquals(2, alleUser.size());

        User gefunden = userManager.readUser("helge@me.com");
        assertEquals("helge@me.com", gefunden.getEmail());
        assertEquals("helge", gefunden.getName());
        assertEquals("passwort", gefunden.getPasswort());
    }

    @Test
    void testAddZweiGleicheUser2AndFindUser() {
        userManager.createUser(new User("helge2@me.com", "helge2", "passwort2", "Admin"));
        userManager.createUser(new User("helge@me.com", "helge", "passwort", "Admin"));

        List<User> alleUser = userManager.readUsers();
        assertEquals(2, alleUser.size());

        User gefunden = userManager.readUser("helge@me.com");
        assertEquals("helge@me.com", gefunden.getEmail());
        assertEquals("helge", gefunden.getName());
        assertEquals("passwort", gefunden.getPasswort());
    }

    @Test
    void testDeleteUser() {
        userManager.createUser(new User("helge@me.com", "helge", "passwort", "Admin"));

        userManager.deleteUser("helge@me.com");

        List<User> alleUser = userManager.readUsers();
        assertEquals(0, alleUser.size());

    }

    @Test
    void testDeleteUserNotIncluded() {
        userManager.createUser(new User("helge2@me.com", "helge", "passwort", "Admin"));

        userManager.deleteUser("helge@me.com");

        List<User> alleUser = userManager.readUsers();
        assertEquals(1, alleUser.size());

    }

    @Test
    void testUpdateUser() {
        userManager.createUser(new User("helge@me.com", "helge", "passwort", "Admin"));

        userManager.updateUser(new User("helge@me.com", "Helge", "superPasswort", "Admin"));

        List<User> alleUser = userManager.readUsers();
        assertEquals(1, alleUser.size());

        User gefunden = userManager.readUser("helge@me.com");
        assertEquals("helge@me.com", gefunden.getEmail());
        assertEquals("Helge", gefunden.getName());
        assertEquals("superPasswort", gefunden.getPasswort());
    }

    @Test
    void testUpdateUserNotFound() {
        userManager.createUser(new User("helge@me.com","helge","passwort", "Admin"));

        try {
            userManager.updateUser(new User("helge2@me.com","Helge", "superPasswort", "Admin"));
            fail("Update User not correct / email not found");
        } catch (RuntimeException e) {

        }
    }

    @Test
    void testUpdateUserExtern() {
        userManager.createUser(new User("helge@me.com", "helge", "passwort", "Admin"));

        User gefunden2 = userManager.readUser("helge@me.com");
        gefunden2.setEmail("helge2@me.com");

        List<User> alleUser = userManager.readUsers();
        assertEquals(1, alleUser.size());

        User gefunden = userManager.readUser("helge@me.com");

        assertEquals("helge@me.com", gefunden.getEmail());
        assertEquals("helge", gefunden.getName());
        assertEquals("passwort", gefunden.getPasswort());
    }
}