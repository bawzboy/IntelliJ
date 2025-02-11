/*
 * Created by JFormDesigner on Tue Feb 11 19:38:20 CET 2025
 */

package user;

import javax.swing.*;
import net.miginfocom.swing.*;
import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.observablecollections.*;

/**
 * @author helge
 */
public class UserView extends JFrame {
    public UserView() {
        initComponents();
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
        label4 = new JLabel();
        observableList1 = new UserModel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[200:200,fill]" +
            "[200:200,fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("nickname");
        contentPane.add(label1, "cell 0 0");
        contentPane.add(textField1, "cell 1 0");

        //---- label2 ----
        label2.setText("email");
        contentPane.add(label2, "cell 0 1");
        contentPane.add(textField2, "cell 1 1");

        //---- label3 ----
        label3.setText("password");
        contentPane.add(label3, "cell 0 2");
        contentPane.add(passwordField1, "cell 1 2");

        //---- button1 ----
        button1.setText("Create User");
        contentPane.add(button1, "cell 0 3");

        //---- button2 ----
        button2.setText("Find User by Email");
        contentPane.add(button2, "cell 1 3");

        //---- button3 ----
        button3.setText("Update User");
        contentPane.add(button3, "cell 0 4");

        //---- button4 ----
        button4.setText("Delete User");
        contentPane.add(button4, "cell 1 4");

        //---- label4 ----
        label4.setText("Status Info");
        contentPane.add(label4, "cell 0 5 2 1,alignx center,growx 0");
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
            label4, BeanProperty.create("text")));
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
    private JLabel label4;
    private UserModel observableList1;
    private BindingGroup bindingGroup;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
