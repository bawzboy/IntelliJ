/*
 * Created by JFormDesigner on Thu Feb 20 16:42:53 CET 2025
 */

package posts;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author helge
 */
public class RegisterView extends JPanel {
    public RegisterView() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Helge
        this2 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label4 = new JLabel();
        textField2 = new JTextField();
        label2 = new JLabel();
        passwordField1 = new JPasswordField();
        label3 = new JLabel();
        passwordField2 = new JPasswordField();
        button2 = new JButton();

        //======== this2 ========
        {
            this2.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax
            . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing
            .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .
            Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red
            ) ,this2. getBorder () ) ); this2. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override
            public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e. getPropertyName (
            ) ) )throw new RuntimeException( ) ;} } );
            this2.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- label1 ----
            label1.setText("E-Mail");
            this2.add(label1, "cell 0 0");
            this2.add(textField1, "cell 1 0");

            //---- label4 ----
            label4.setText("Name");
            this2.add(label4, "cell 0 1");
            this2.add(textField2, "cell 1 1");

            //---- label2 ----
            label2.setText("Passwort");
            this2.add(label2, "cell 0 2");
            this2.add(passwordField1, "cell 1 2");

            //---- label3 ----
            label3.setText("Passwort wiederholen");
            this2.add(label3, "cell 0 3");
            this2.add(passwordField2, "cell 1 3");

            //---- button2 ----
            button2.setText("Registrieren");
            this2.add(button2, "cell 1 4");
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Helge
    private JPanel this2;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label4;
    private JTextField textField2;
    private JLabel label2;
    private JPasswordField passwordField1;
    private JLabel label3;
    private JPasswordField passwordField2;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
