package user;

import java.util.List;

public class UserManager {
    private PersistUsers users;

    public UserManager() {
        this.users = new PersistUsers();
    }

    public void createUser(UserModel user) {
        UserModel newUser = new UserModel(user);
        users.getUsers().add(newUser);
        users.saveUsers();
    }

    public UserModel readUser(String email) {
        for (UserModel user : users.getUsers()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public List<UserModel> readUsers() {
        return users.getUsers();
    }

    public void updateUser(UserModel user) {
        UserModel existingUser = readUser(user.getEmail());
        if (existingUser != null) {
            existingUser.setNickname(user.getNickname());
            existingUser.setPassword(user.getPassword());
        }
        users.saveUsers();
    }

    public void deleteUser(String email) {
        UserModel user = readUser(email);
        if (user != null) {
            users.getUsers().remove(readUser(email));
        }
        users.saveUsers();
    }

}
