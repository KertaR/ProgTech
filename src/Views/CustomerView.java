package Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class CustomerView extends JFrame {

    private JPanel rootpanel;
    private JComboBox selectdrink;
    private JTextField fullname;
    private JButton order;
    private JTable datas;
    private JButton logout;
    private DefaultTableModel model;
    public CustomerView(){
        add(rootpanel);
        setTitle("Rendelés");
        setSize(700,300);
        datas.setDefaultEditor(Object.class, null);
        datas.getTableHeader().setReorderingAllowed(false);
        Object[] columns = {"Felhasználónév", "Rendelés", "Folyamat", "Ár"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        datas.setModel(model);
    }

    public DefaultTableModel GetModel(){
        return model;
    }
    public String GetFullname(){
        return fullname.getText();
    }
    public String GetSelectedDrink(){
        return selectdrink.getSelectedItem().toString();
    }
    public void UploadActionListener(ActionListener listener)
    {
        this.order.addActionListener(listener);
    }
    public void LogoutActionListener(ActionListener listener)
    {
        this.logout.addActionListener(listener);
    }
}
