package user;

public class Test {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();

        userManager.createUser("testUser", "test@example.com", "1234");
        userManager.createUser("user2", "user2@example.com", "abcd");

        System.out.println("Alle Benutzer:");
        userManager.readUsers();

        System.out.println("Benutzer lesen:");
        System.out.println(userManager.readUser("test@example.com"));

        System.out.println("Benutzer aktualisieren:");
        userManager.updateUser("test@example.com", "updatedUser", "newpass");
        userManager.readUsers();

        System.out.println("Benutzer löschen:");
        userManager.deleteUser("user2@example.com");
        userManager.readUsers();
    }
}
