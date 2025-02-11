package user;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    List<UserModel> alleUser = new ArrayList<>();

    public void createUser(UserModel user) {
        alleUser.add(user);
    }

//    public UserModel readUser(String email) {
//        for (UserModel user: alleUser) {
//            if (email == user.getEmail()) {
//                return user;
//            }
//        }
//    }

    public List<UserModel> readUsers() {
        return alleUser;
    }

//    public boolean updateUser(UserModel user) {}
//
//    public boolean deleteUser(UserModel user) {}
}
