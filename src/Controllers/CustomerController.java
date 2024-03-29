package Controllers;

import Models.CustomerModel;
import Views.CustomerView;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CustomerController {
    private CustomerView view;
    private CustomerModel model;
    public CustomerController(CustomerView view, CustomerModel model)
    {
        this.view = view;
        this.model = model;
        model.GetData(view.GetModel());
        view.UploadActionListener(new UploadListener());
        view.LogoutActionListener(new LogoutListener());
    }

    class UploadListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String fullname,selectdrink = "";
            DefaultTableModel tablemodel = view.GetModel();
            fullname = view.GetFullname();
            selectdrink = view.GetSelectedDrink();
            model.AddData(fullname, selectdrink, tablemodel);
        }
    }
    class LogoutListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model.Logout();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
