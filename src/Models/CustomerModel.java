package Models;

import Logger.Log;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;

public class CustomerModel {
    Log mylog = new Log("logs.txt");

    public CustomerModel() throws IOException {
    }

    public void AddData(String fullname, String selectdrink, DefaultTableModel model){
        Object[] row = new Object[4];
        row[0] = fullname;
        row[1] = selectdrink;
        row[2] = "Feldolgozás...";
        row[3] = "Hamarosan...";
        model.addRow(row);
        mylog.logger.info("Adatok feltöltése...");
    }
}
