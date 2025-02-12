/*
 * Created by JFormDesigner on Tue Feb 11 19:38:20 CET 2025
 */

package user;

import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.observablecollections.*;

/**
 * @author helge
 */
public class UserView extends JFrame {
    private UserManager userManager = new UserManager();

    public UserView() {
        initComponents();
    }

    private void createUser(ActionEvent e) {
        String nickname = textField1.getText();
        String email = textField2.getText();
        char[] passwordChars = passwordField1.getPassword();
        String password = new String(passwordChars);

        if (!nickname.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
            userManager.createUser(nickname, email, password);
            textField3.setText("User created successfully!");
        } else {
            textField3.setText("All fields must be filled!");
        }
    }

    private void findUser(ActionEvent e) {
        String email = textField2.getText();
        UserModel foundUser = userManager.readUser(email);
        textField1.setText(foundUser.getNickname());
        passwordField1.setText(foundUser.getPassword());
        textField3.setText(userManager.readUser(email).toString());
    }

    private void updateUser(ActionEvent e) {
        String email = textField2.getText();
        UserModel user = userManager.readUser(email);
        user.setNickname(textField1.getText());
        char[] passwordChars = passwordField1.getPassword();
        String password = new String(passwordChars);
        user.setPassword(password);
        textField3.setText("User updated!");
    }

    private void deleteUser(ActionEvent e) {
        String email = textField2.getText();
        userManager.deleteUser(email);
        textField3.setText("User deleted!");
        textField1.setText("");
        textField2.setText("");
        passwordField1.setText("");
    }

    private void showAllUsers(ActionEvent e) {
        textField3.setText(userManager.readUsers().toString());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Helge
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        textField3 = new JTextField();
        observableList1 = new UserModel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[200:200,fill]" +
            "[fill]" +
            "[200:200,fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("nickname");
        contentPane.add(label1, "cell 0 0");
        contentPane.add(textField1, "cell 2 0");

        //---- label2 ----
        label2.setText("email");
        contentPane.add(label2, "cell 0 1");
        contentPane.add(textField2, "cell 2 1");

        //---- label3 ----
        label3.setText("password");
        contentPane.add(label3, "cell 0 2");
        contentPane.add(passwordField1, "cell 2 2");

        //---- button1 ----
        button1.setText("Create User");
        button1.addActionListener(e -> createUser(e));
        contentPane.add(button1, "cell 0 3");

        //---- button2 ----
        button2.setText("Find User by Email");
        button2.addActionListener(e -> findUser(e));
        contentPane.add(button2, "cell 2 3");

        //---- button3 ----
        button3.setText("Update User");
        button3.addActionListener(e -> updateUser(e));
        contentPane.add(button3, "cell 0 4");

        //---- button4 ----
        button4.setText("Delete User");
        button4.addActionListener(e -> deleteUser(e));
        contentPane.add(button4, "cell 2 4");

        //---- button5 ----
        button5.setText("Show all Users");
        button5.addActionListener(e -> showAllUsers(e));
        contentPane.add(button5, "cell 0 5");

        //---- textField3 ----
        textField3.setEditable(false);
        contentPane.add(textField3, "cell 0 6 3 1,align center center,grow 0 0,wmin 450,hmin 100");
        pack();
        setLocationRelativeTo(getOwner());

        //---- bindings ----
        bindingGroup = new BindingGroup();
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            observableList1, BeanProperty.create("nickname"),
            textField1, BeanProperty.create("text")));
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            observableList1, BeanProperty.create("email"),
            textField2, BeanProperty.create("text")));
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            observableList1, BeanProperty.create("password"),
            passwordField1, BeanProperty.create("text")));
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            observableList1, BeanProperty.create("statusInfo"),
            textField3, BeanProperty.create("text")));
        bindingGroup.bind();
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Helge
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JTextField textField3;
    private UserModel observableList1;
    private BindingGroup bindingGroup;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
