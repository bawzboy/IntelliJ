package user;

import javax.swing.*;

public class UserController {
    public static void main(String[] args) {
        UserView view = new UserView();
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setVisible(true);
    }
}
