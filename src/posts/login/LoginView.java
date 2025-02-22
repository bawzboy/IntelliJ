/*
 * Created by JFormDesigner on Tue Feb 18 19:31:29 CET 2025
 */

package posts.login;

import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

/**
 * @author helge
 */
public class LoginView extends JPanel{
    InterfaceLogin interfaceLogin;

    public LoginView(InterfaceLogin interfaceLogin) {
        this.interfaceLogin = interfaceLogin;  // Assign the interface instance
        initComponents();
    }

    private void loginButton(ActionEvent e) {
        interfaceLogin.passwordCheck();
    }

    private void registrierenButton(ActionEvent e) {
        // TODO add your code here
    }

    public LoginModel getObservableList1() {
        return observableList1;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Helge
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();
        observableList1 = new LoginModel();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
        . swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing
        . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
        Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
        ) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
        public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName (
        ) )) throw new RuntimeException( ); }} );
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("E-Mail");
        add(label1, "cell 0 0");
        add(textField1, "cell 1 0");

        //---- label2 ----
        label2.setText("Passwort");
        add(label2, "cell 0 1");
        add(passwordField1, "cell 1 1");

        //---- button1 ----
        button1.setText("Login");
        button1.addActionListener(e -> loginButton(e));
        add(button1, "cell 1 2");

        //---- button2 ----
        button2.setText("Registrieren");
        button2.addActionListener(e -> registrierenButton(e));
        add(button2, "cell 1 3");

        //---- bindings ----
        bindingGroup = new BindingGroup();
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            observableList1, BeanProperty.create("email"),
            textField1, BeanProperty.create("text")));
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            observableList1, BeanProperty.create("passwort"),
            passwordField1, BeanProperty.create("text")));
        bindingGroup.bind();
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Helge
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    private LoginModel observableList1;
    private BindingGroup bindingGroup;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
