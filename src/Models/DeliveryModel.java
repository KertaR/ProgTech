package Models;

import Logger.Log;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;

public class DeliveryModel {
    Log mylog = new Log("logs.txt");
    DBConnect dbConnect = new DBConnect();

    public DeliveryModel() throws IOException {
    }

    /**
     *
     * @param i megvizsgálja hogy van e kijelölt elem
     * @param process lekéri a proccesst
     * @param model ezen a modelen át keresztül
     */
    public void UpdateData(int i, String process, DefaultTableModel model){
        mylog.logger.info("Adatok módosítása...");
        int id = 0;
        if (i>=0){
            model.setValueAt(process,i,3);
            id = Integer.parseInt(model.getValueAt(i,0).toString());
        }
        dbConnect.UpdateProcessData(process,id,model);
        GetData(model);
    }

    /**
     *
     * @param model modelt frissiti
     */
    public void GetData(DefaultTableModel model){
        dbConnect.GetData2(model);
    }
}
