/*
 * Created by JFormDesigner on Tue Feb 25 15:19:58 CET 2025
 */

package posts.navigation;

import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.observablecollections.*;
import posts.eventBus.EventBus;
import posts.messages.Logout;
import posts.messages.ShowNewPage;

/**
 * @author helge
 */
public class NavigationView extends JPanel {
    public NavigationView() {
        initComponents();
    }

    public JMenuBar getMenuBar1() {
        return menuBar1;
    }

    private void menuItem1(ActionEvent e) {
        EventBus.getInstance().sendMessage(new ShowNewPage("AdminConsole"));
    }

    private void menuItem2(ActionEvent e) {
        EventBus.getInstance().sendMessage(new ShowNewPage("NewPost"));
    }

    private void menuItem3(ActionEvent e) {
            EventBus.getInstance().sendMessage(new ShowNewPage("Login"));
    }

    public NavigationModel getObservableList1() {
        return observableList1;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Eric
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();
        observableList1 = new NavigationModel();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
        . EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder. CENTER, javax
        . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .awt .Font .BOLD ,
        12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans
        . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .
        getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]"));

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("Navigation");

                //---- menuItem1 ----
                menuItem1.setText("Benutzerverwaltung");
                menuItem1.addActionListener(e -> menuItem1(e));
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("Post erstellen");
                menuItem2.addActionListener(e -> menuItem2(e));
                menu1.add(menuItem2);

                //---- menuItem3 ----
                menuItem3.setText("Logout");
                menuItem3.addActionListener(e -> menuItem3(e));
                menu1.add(menuItem3);
            }
            menuBar1.add(menu1);
        }
        add(menuBar1, "cell 0 0");

        //---- bindings ----
        bindingGroup = new BindingGroup();
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            observableList1, BeanProperty.create("loginSuccessful"),
            menuItem1, BeanProperty.create("visible")));
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            observableList1, BeanProperty.create("loginSuccessful"),
            menuItem2, BeanProperty.create("visible")));
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            observableList1, BeanProperty.create("loginSuccessful"),
            menuItem3, BeanProperty.create("visible")));
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            observableList1, BeanProperty.create("loginSuccessful"),
            menu1, BeanProperty.create("visible")));
        bindingGroup.bind();
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Eric
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private NavigationModel observableList1;
    private BindingGroup bindingGroup;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
