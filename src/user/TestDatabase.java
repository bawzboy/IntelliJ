package user;

public class TestDatabase{
    public static void main(String[] args) {
        UserManager manager = new UserManager();
        UserModel testUser = new UserModel();
        testUser.setEmail("testuser@me.com");
        testUser.setNickname("Testuser");
        testUser.setPassword("Passw0rd!");

        manager.createUser(testUser);
        manager.readUser(testUser.getEmail());
        manager.updateUser(testUser);
        manager.deleteUser(testUser.getEmail());
    }
}
