package Models;

import Controllers.LoginController;
import Logger.Log;
import Views.LoginView;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;

public class CustomerModel {
    Log mylog = new Log("logs.txt");

    public CustomerModel() throws IOException {
    }

    public void AddData(String fullname, String selectdrink, DefaultTableModel model){
        mylog.logger.info("Adatok feltöltése...");
        Object[] row = new Object[4];
        row[0] = fullname;
        row[1] = selectdrink;
        row[2] = "Feldolgozás...";
        row[3] = "Ár...";
        model.addRow(row);
    }
    public void Logout() throws IOException {
        mylog.logger.info("Kijelentkezés...");
        LoginView cv = new LoginView();
        LoginModel cm = new LoginModel();
        LoginController cc = new LoginController(cv, cm);
        cv.setVisible(true);
    }
}
