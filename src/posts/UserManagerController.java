package posts;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserManagerController implements InterfaceUserManager {
    UserManagerJDBC userManager;
    private User model;
//    UserView view = new UserView();

    private final Pattern nicknamePattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_.-]{2,19}$");
    private final Pattern emailPattern = Pattern.compile("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
    private final Pattern passwordPattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    public static void main(String[] args) {
        UserManagerController userController = new UserManagerController();
//        userManagerController.initView();
    }

    private void initView() {
        userManager = new UserManagerJDBC();
//        model = view.getObservableList1();
//        view.setInterfaceUserManager(this);
//
//        view.getTextField1().setInputVerifier(getValidation(nicknamePattern));
//        view.getTextField2().setInputVerifier(getValidation(emailPattern));
//        view.getPasswordField1().setInputVerifier(getValidation(passwordPattern));
//
//        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        view.setVisible(true);
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public User readUser(String email) {
        return null;
    }

    @Override
    public void deleteUser(String email) {

    }

    @Override
    public void updateUser(User user) {

    }



    @Override
    public boolean createUser() {
        userManager.createUser(new User(model));
        clearTextFields();
        return true;
    }


    private void clearTextFields() {
        model.setEmail("");
        model.setPasswort("");
        model.setName("");
    }

    @Override
    public User readUser() {
        User user = userManager.readUser(model.getEmail());
        model.setEmail(user.getEmail());
        model.setPasswort(user.getPasswort());
        model.setName(user.getName());
//        view.getTextField2().setEditable(false);
        return model;
    }

    @Override
    public boolean readUsers() {
        return true;
    }

    @Override
    public User findUserByEmail(String email) {
        User user = userManager.readUser(email);
        if (user == null) {
            return null;
        }
        model.setEmail(user.getEmail());
        model.setPasswort(user.getPasswort());
        model.setName(user.getName());
        return model;
    }

    @Override
    public User findUserByEmail() {
        return null;
    }

    @Override
    public boolean updateUser() {
        userManager.updateUser(model);
        return true;
    }

    @Override
    public boolean deleteUser() {
        userManager.deleteUser(model.getEmail());
        clearTextFields();
//        view.getTextField2().setEditable(true);
        return true;
    }

//    @Override
//    public List<UserModel> showAllUsers() {
//        List<UserModel> userList = new ArrayList<>(userManager.readUsers());
//        model.setStatusInfo(userList.toString());
//        return userList;
//    }

    InputVerifier getValidation(Pattern regex) {
        return new InputVerifier() {
            public boolean verify(JComponent input) {
                JTextField textField = (JTextField) input;
                String text = textField.getText();
                boolean isValid = text.isEmpty() || regex.matcher(text).matches();
                textField.setBackground(isValid ? Color.white : Color.red);
                return isValid;
            }
        };
    }
}
