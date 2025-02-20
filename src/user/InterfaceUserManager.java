package user;

public interface InterfaceUserManager {
    public boolean createUser();
    public UserModel readUser();
    public boolean readUsers();
    public boolean updateUser();
    public boolean deleteUser();
}