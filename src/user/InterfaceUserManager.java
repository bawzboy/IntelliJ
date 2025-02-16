package user;

import java.util.List;

public interface InterfaceUserManager {
    public boolean createUser();
    public UserModel findUser();
    public boolean updateUser();
    public boolean deleteUser();
    public List<UserModel> showAllUsers();
    public boolean findSelectedUser();
}
