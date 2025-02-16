/*
 * Created by JFormDesigner on Tue Feb 11 19:38:20 CET 2025
 */

package user;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.event.*;
import net.miginfocom.swing.*;
import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.observablecollections.*;
import org.jdesktop.swingbinding.*;

/**
 * @author helge
 */
public class UserView extends JFrame {

    InterfaceUserManager interfaceUserManager;

    public void setInterfaceUserManager(InterfaceUserManager interfaceUserManager) {
        this.interfaceUserManager = interfaceUserManager;
    }

    public UserView() {
        initComponents();
    }

    public UserModel getObservableList1() {
        return observableList1;
    }

    private void createUser(ActionEvent e) {
        interfaceUserManager.createUser();
    }

    private void findUser(ActionEvent e) {
        interfaceUserManager.findUser();
    }

    private void updateUser(ActionEvent e) {
        interfaceUserManager.updateUser();
    }

    private void deleteUser(ActionEvent e) {
        interfaceUserManager.deleteUser();
    }

    private void showAllUsers(ActionEvent e) {
        interfaceUserManager.showAllUsers();
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }

    public UserSelectionModel getObservableList2() {
        return observableList2;
    }

    private void list1ValueChanged(ListSelectionEvent e) {
        interfaceUserManager.findSelectedUser();
    }

    private void comboBox1ValueChanged(ListSelectionEvent e) {
        interfaceUserManager.findSelectedUser();
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
        comboBox1 = new JComboBox();
        textField3 = new JTextField();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        observableList1 = new UserModel();
        observableList2 = new UserSelectionModel();

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
        contentPane.add(comboBox1, "cell 2 5");

        //---- textField3 ----
        textField3.setEditable(false);
        contentPane.add(textField3, "cell 0 6,align center center,grow 0 0,wmin 200,hmin 100");

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.addListSelectionListener(e -> list1ValueChanged(e));
            scrollPane1.setViewportView(list1);
        }
        contentPane.add(scrollPane1, "cell 2 6");
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
        bindingGroup.addBinding(SwingBindings.createJComboBoxBinding(UpdateStrategy.READ_WRITE,
            observableList2, (BeanProperty) BeanProperty.create("allEmails"), comboBox1));
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            observableList2, BeanProperty.create("selectedEmail"),
            comboBox1, BeanProperty.create("selectedItem")));
        bindingGroup.addBinding(SwingBindings.createJListBinding(UpdateStrategy.READ_WRITE,
            observableList2, (BeanProperty) BeanProperty.create("allEmails"), list1));
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            observableList2, BeanProperty.create("selectedEmail"),
            list1, BeanProperty.create("selectedElement")));
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
    private JComboBox comboBox1;
    private JTextField textField3;
    private JScrollPane scrollPane1;
    private JList list1;
    private UserModel observableList1;
    private UserSelectionModel observableList2;
    private BindingGroup bindingGroup;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
