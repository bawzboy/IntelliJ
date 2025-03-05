/*
 * Created by JFormDesigner on Wed Mar 05 16:50:48 CET 2025
 */

package posts.follower;

import javax.swing.*;
import net.miginfocom.swing.*;
import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.observablecollections.*;
import org.jdesktop.swingbinding.*;

/**
 * @author helge
 */
public class FollowerView extends JPanel {
    public FollowerView() {
        initComponents();
    }

    public FollowerModel getObservableList1() {
        return observableList1;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Helge
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        scrollPane2 = new JScrollPane();
        list2 = new JList();
        scrollPane3 = new JScrollPane();
        list3 = new JList();
        observableList1 = new FollowerModel();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
        javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax
        . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
        .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans.
        PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .
        equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[120:n,fill]" +
            "[120:n,fill]" +
            "[120:n,fill]",
            // rows
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Dir folgen");
        add(label1, "cell 0 0");

        //---- label2 ----
        label2.setText("Du folgst");
        add(label2, "cell 1 0");

        //---- label3 ----
        label3.setText("Du k\u00f6nntest folgen");
        add(label3, "cell 2 0");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1, "cell 0 1");

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(list2);
        }
        add(scrollPane2, "cell 1 1");

        //======== scrollPane3 ========
        {
            scrollPane3.setViewportView(list3);
        }
        add(scrollPane3, "cell 2 1");

        //---- bindings ----
        bindingGroup = new BindingGroup();
        bindingGroup.addBinding(SwingBindings.createJListBinding(UpdateStrategy.READ_WRITE,
            observableList1, (BeanProperty) BeanProperty.create("follower"), list1));
        bindingGroup.addBinding(SwingBindings.createJListBinding(UpdateStrategy.READ_WRITE,
            observableList1, (BeanProperty) BeanProperty.create("following"), list2));
        bindingGroup.addBinding(SwingBindings.createJListBinding(UpdateStrategy.READ_WRITE,
            observableList1, (BeanProperty) BeanProperty.create("userToFollow"), list3));
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            observableList1, BeanProperty.create("selectedFollower"),
            list1, BeanProperty.create("selectedElement")));
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            observableList1, BeanProperty.create("selectedFollowing"),
            list2, BeanProperty.create("selectedElement")));
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            observableList1, BeanProperty.create("selectedUserToFollow"),
            list3, BeanProperty.create("selectedElement")));
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            observableList1, BeanProperty.create("selectedUsersToFollow"),
            list3, BeanProperty.create("selectedElements")));
        bindingGroup.bind();
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Helge
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JList list1;
    private JScrollPane scrollPane2;
    private JList list2;
    private JScrollPane scrollPane3;
    private JList list3;
    private FollowerModel observableList1;
    private BindingGroup bindingGroup;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
