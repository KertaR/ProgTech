package Models;

import Decorator.Cukor;
import Decorator.Citrom;
import Template.*;
import Logger.Log;

import javax.swing.*;
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
    public void Elkeszites(JTextArea szoveg, int i, DefaultTableModel model){
        mylog.logger.info("Adatok módosítása...");
        String tea = "";
        if (i>=0){
            tea = model.getValueAt(i,2).toString();
        }
        if (tea.equals("Zöld Tea")){
            Decorator.Tea dt = new Citrom(new Decorator.ZoldTea());
            Template.Tea tt = new ZoldTea();
            tt.Elkeszit(szoveg);
            szoveg.append("Hozzávalók: \n");
            szoveg.append(dt.GetMin() + " perc \n");
            szoveg.append(dt.GetHozzavalok() + "\n");
        }
        if (tea.equals("Fekete Tea")){
            Decorator.Tea dt = new Decorator.FeketeTea();
            Template.Tea tt = new FeketeTea();
            tt.Elkeszit(szoveg);
            szoveg.append("Hozzávalók: \n");
            szoveg.append(dt.GetMin() + " perc \n");
            szoveg.append(dt.GetHozzavalok() + "\n");
        }
        if (tea.equals("Gyümölcs Tea")){
            Decorator.Tea dt = new Cukor(new Citrom(new Decorator.GyumolcsTea()));
            Template.Tea tt = new GyumolcsTea();
            tt.Elkeszit(szoveg);
            szoveg.append("Hozzávalók: \n");
            szoveg.append(dt.GetMin() + " perc \n");
            szoveg.append(dt.GetHozzavalok() + "\n");
        }
    }

    /**
     *
     * @param model modelt frissiti
     */
    public void GetData(DefaultTableModel model){
        dbConnect.GetData2(model);
    }
}
