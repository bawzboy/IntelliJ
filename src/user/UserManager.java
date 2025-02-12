package user;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<UserModel> alleUser = new ArrayList<>();

    public void createUser(String nickname, String email, String password) {
        UserModel newUser = new UserModel(nickname, email, password);
        alleUser.add(newUser);
    }

    public UserModel readUser(String email) {
        for (UserModel user: alleUser) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public List<UserModel> readUsers() {
        return new ArrayList<>(alleUser);
    }

    public void updateUser(UserModel userModel) {
        UserModel existingUser = readUser(userModel.getEmail());
        if (existingUser != null) {
            existingUser.setNickname(userModel.getNickname());
            existingUser.setPassword(userModel.getPassword());
        }
    }

    public void updateUser(String nickname, String email, String password) {
        updateUser(new UserModel(nickname, email, password));
    }

    public void deleteUser(String email) {
        UserModel user = readUser(email);
        if (user != null) {
            alleUser.remove(readUser(email));
        }
    }
}
