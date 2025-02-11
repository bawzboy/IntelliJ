package user;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    List<UserModel> alleUser = new ArrayList<>();

    public void createUser(UserModel user) {
        alleUser.add(user);
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
        for (UserModel user : alleUser) {
            System.out.println(user);
        }
    }

    public boolean updateUser(UserModel UserModel) {
        for (UserModel user: alleUser) {
            if (user.getEmail().equals(UserModel.getEmail())) {
                user.setNickname(UserModel.getNickname());
                user.setPassword(UserModel.getPassword());
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(UserModel user) {
        return alleUser.remove(user);
    }
}

//package user;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserManager {
//    List<UserModel> alleUser = new ArrayList<>();
//
//    public void createUser(String nickname, String email, String password) {
//        alleUser.add(new UserModel(nickname, email, password));
//    }
//
//    public UserModel readUser(String email) {
//        for (UserModel user: alleUser) {
//            if (user.getEmail().equals(email)) {
//                return user;
//            }
//        }
//        return null;
//    }
//
//    public void readUsers() {
//        for (UserModel user : alleUser) {
//            System.out.println(user);
//        }
//    }
//
//    public void updateUser(String newNickname, String email, String newPassword) {
//        UserModel user = readUser(email);
//        if (user != null) {
//            user.setNickname(newNickname);
//            user.setPassword(newPassword);
//        }
//    }
//
//    public void deleteUser(String email) {
//        alleUser.remove(readUser(email));
//    }
//}

