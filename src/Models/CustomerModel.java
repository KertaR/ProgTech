package Models;

import Controllers.LoginController;
import Logger.Log;
import Views.LoginView;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;

public class CustomerModel {
    Log mylog = new Log("logs.txt");
    DBConnect dbConnect = new DBConnect();

    public CustomerModel() throws IOException
    {

    }

    /**
     *
     * @param model modelt frissiti
     */
    public void GetData(DefaultTableModel model){
        dbConnect.GetData(model);
    }

    /**
     * Feltölti adatokkal a model-t ezáltal a táblát is
     * @param fullname lementi a nevet
     * @param selectdrink lementi hogy mi a kivalasztott ital
     * @param model ebbe a modelbe rakja
     */
    public void AddData(String fullname, String selectdrink, DefaultTableModel model){

        if (fullname.length() > 5){
            mylog.logger.info("Adatok feltöltése...");
            dbConnect.AddData(fullname,selectdrink,model);
            dbConnect.GetData(model);
        }
        else{
            mylog.logger.info("Hiba..");
        }
    }

    /**
     *  Kijelentkezési felület azt a célt szolgálja hogy egy felhasználó ki tudjon jelentkezni
     * @throws IOException
     */
    public void Logout() throws IOException {
        mylog.logger.info("Kijelentkezés...");
        LoginView cv = new LoginView();
        LoginModel cm = new LoginModel();
        LoginController cc = new LoginController(cv, cm);
        cv.setVisible(true);
    }
}
