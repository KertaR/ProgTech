package Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class DeliveryView extends JFrame {
    private JPanel rootpanel;
    private JTable datas;
    private JButton elfogadButton;
    private JComboBox Process;
    private JTextArea szovegdoboz;
    private JButton elkeszites;
    private DefaultTableModel model;
    public DeliveryView(){
        add(rootpanel);
        setTitle("Kiszállítás");
        setSize(700,300);
        datas.setDefaultEditor(Object.class, null);
        datas.getTableHeader().setReorderingAllowed(false);
        Object[] columns = {"ID","Felhasználónév", "Rendelés", "Folyamat", "Ár"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        datas.setModel(model);
    }
    public String GetProcess(){
        return Process.getSelectedItem().toString();
    }
    public JTable GetDatas(){
        return datas;
    }
    public DefaultTableModel GetModel(){
        return model;
    }
    public JTextArea GetSzovegdoboz() {return szovegdoboz; }
    public void EditingActionListener(ActionListener listener)
    {
        this.elfogadButton.addActionListener(listener);
    }
    public void ElkeszitesActionListener(ActionListener listener)
    {
        this.elkeszites.addActionListener(listener);
    }
}
