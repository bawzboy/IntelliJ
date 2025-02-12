package user;

import java.util.List;

public class UserManager {
    private PersistUsers users;

    public UserManager() {
        this.users = new PersistUsers(); // Initialize PersistUsers here
    }

    public void createUser(String nickname, String email, String password) {
        UserModel newUser = new UserModel(nickname, email, password);
        users.getUsers().add(newUser);
        users.saveUsers();
    }

    public UserModel readUser(String email) {
        for (UserModel user: users.getUsers()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public List<UserModel> readUsers() {
        return users.getUsers();
    }

    public void updateUser(UserModel userModel) {
        UserModel existingUser = readUser(userModel.getEmail());
        if (existingUser != null) {
            existingUser.setNickname(userModel.getNickname());
            existingUser.setPassword(userModel.getPassword());
        }
        users.saveUsers();
    }

    public void updateUser(String nickname, String email, String password) {
        updateUser(new UserModel(nickname, email, password));
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
