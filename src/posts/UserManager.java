package posts;

import java.util.ArrayList;
import java.util.List;

public class UserManager implements InterfaceUserManager {
    List<User> userListe = new ArrayList<>();

    @Override
    public List<User> readUsers() {
        return new ArrayList<>(userListe);
    }

    @Override
    public void createUser(User user) {
        User foundUser = this.readUser(user.getEmail());
        if(foundUser == null) {
            userListe.add(user);
        } else {
            throw new RuntimeException();
        }

    }

    @Override
    public User readUser(String email) {
        for(User user : userListe) {
            if(email.equals(user.getEmail())) {
                return new User(user);
            }
        }
        return null;
    }

    @Override
    public void deleteUser(String email) {
        User foundUser = this.readUser(email);
        userListe.remove(foundUser);
    }

    @Override
    public void updateUser(User userUpdate) {

        for(User user : userListe) {
            if(user.getEmail().equals(userUpdate.getEmail())) {
                user.setName(userUpdate.getName());
                user.setPasswort(userUpdate.getPasswort());
                return ;
            }
        }
        throw new RuntimeException();
    }
}
