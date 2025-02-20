package posts;

import java.util.List;

public interface InterfaceUserManager {

    public List<User> readUsers();

    public void createUser(User user);

    public User readUser(String email);

    public void deleteUser(String email);

    public void updateUser(User user);
}
