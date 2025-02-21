/*
 * Created by JFormDesigner on Wed Feb 19 18:07:06 CET 2025
 */

package posts.benutzerverwaltung;

import javax.swing.*;
import javax.swing.table.*;
import net.miginfocom.swing.*;

/**
 * @author helge
 */
public class BenutzerverwaltungScreen extends JPanel {
    public BenutzerverwaltungScreen() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Helge
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
        EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing
        . border. TitledBorder. BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .awt .Font .BOLD ,12 ),
        java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( )
        { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .getPropertyName () ))
        throw new RuntimeException( ); }} );
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]"));

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null},
                    {null, null, null},
                },
                new String[] {
                    "ID", "E-Mail", "L\u00f6schen"
                }
            ));
            {
                TableColumnModel cm = table1.getColumnModel();
                cm.getColumn(0).setMinWidth(50);
                cm.getColumn(0).setMaxWidth(50);
                cm.getColumn(0).setPreferredWidth(50);
                cm.getColumn(1).setMinWidth(200);
                cm.getColumn(1).setMaxWidth(200);
                cm.getColumn(1).setPreferredWidth(200);
                cm.getColumn(2).setMinWidth(100);
                cm.getColumn(2).setMaxWidth(100);
                cm.getColumn(2).setPreferredWidth(100);
            }
            table1.setCellSelectionEnabled(true);
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1, "cell 0 1,width :350:400");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Helge
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
