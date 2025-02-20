package user;

public interface InterfaceUserController {
    public boolean createUser();
    public UserModel findUserByEmail();

    UserModel findUserByEmail(String email);

    public boolean updateUser();
    public boolean deleteUser();
    public void clearSelection();
    public boolean findSelectedUser();
}
