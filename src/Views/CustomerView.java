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
    private DefaultTableModel model;

    public CustomerView(){
        add(rootpanel);
        setTitle("Rendelés");
        setSize(700,300);

        Object[] columns = {"Felhasználónév", "Rendelés", "Folyamat", "Üzenet"};
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
    public JTable GetDatas(){
        return datas;
    }
    public void UploadActionListener(ActionListener listener)
    {
        this.order.addActionListener(listener);
    }
}
