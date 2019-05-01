package Models;
import Controllers.CustomerController;
import Logger.Log;
import Views.CustomerView;

import java.io.IOException;
import java.util.logging.Level;

public class LoginModel {
    Log mylog = new Log("logs.txt");
    DBConnect dbConnect = new DBConnect();
    public LoginModel() throws IOException {
    }

    public boolean IsUser(String username, String password){
        boolean isUser = dbConnect.IsUser(username,password);
        if (isUser){
            mylog.logger.info("Sikeres bejelentkezés");
        }
        else {
            mylog.logger.info("Sikertelen bejelentkezés");
        }
        return isUser;
    }

    /**
     * Átirányítás
     */
    public void Redirecting() throws IOException {
        CustomerView cv = new CustomerView();
        CustomerModel cm = new CustomerModel();
        CustomerController cc = new CustomerController(cv, cm);
        cv.setVisible(true);
    }
}
