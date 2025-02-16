package user;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserController implements InterfaceUserManager {
    UserManager userManager;
    private UserModel model;
    private UserSelectionModel modelMailSelection;
    UserView view = new UserView();  // benötigt um Zugriff auf textField zu bekommen
//    List<String> mails = new ArrayList<String>();

    private final Pattern nicknamePattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_.-]{2,19}$");
    private final Pattern emailPattern = Pattern.compile("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
    private final Pattern passwordPattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.initView();
    }

    private void initView() {
        userManager = new UserManager();
//        UserView view = new UserView();
        model = view.getObservableList1();
        modelMailSelection = view.getObservableList2();
        initMailSelection();
        view.setInterfaceUserManager(this);

        view.getTextField1().setInputVerifier(getValidation(nicknamePattern));
        view.getTextField2().setInputVerifier(getValidation(emailPattern));
        view.getPasswordField1().setInputVerifier(getValidation(passwordPattern));

        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setVisible(true);
    }

    private void initMailSelection() {
        List<String> mails = new ArrayList<String>();
        for (UserModel user: userManager.readUsers()) {
            mails.add(user.getEmail());
        }
        modelMailSelection.setAllEmails(mails);
    }

    @Override
    public boolean createUser() {
        userManager.createUser(new UserModel(model));
        clearTextFields();
        initMailSelection();
        return true;
    }

    private void clearTextFields() {
        model.setEmail("");
        model.setPassword("");
        model.setNickname("");
    }

    @Override
    public UserModel findUser() {
        UserModel user = userManager.readUser(model.getEmail());
        model.setEmail(user.getEmail());
        model.setPassword(user.getPassword());
        model.setNickname(user.getNickname());
        view.getTextField2().setEditable(false);
        return model;
    }

    public UserModel findUserByEmail(String email) {
        UserModel user = userManager.readUser(email);
        if (user == null) {
            return null;
        }
        model.setEmail(user.getEmail());
        model.setPassword(user.getPassword());
        model.setNickname(user.getNickname());
        return model;
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
        initMailSelection();
        modelMailSelection.setSelectedEmail(null);
        return true;
    }

    @Override
    public void clearSelection() {
        modelMailSelection.setSelectedEmail(null);
        view.getTextField2().setEditable(true);
        clearTextFields();
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
                boolean isValid = regex.matcher(text).matches();
                textField.setBackground(isValid ? Color.white : Color.red);
                return isValid;
            }
        };
    }

    @Override
    public boolean findSelectedUser() {
        findUserByEmail(modelMailSelection.getSelectedEmail());
        view.getTextField2().setEditable(false);
        return true;
    }
}
