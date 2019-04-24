package Models;

import Controllers.CustomerController;
import Logger.Log;
import Views.CustomerView;

import java.io.IOException;
import java.util.logging.Level;

public class LoginModel {
    Log mylog = new Log("logs.txt");

    public LoginModel() throws IOException {
    }

    public boolean IsUser(String username, String password){
        if (username.equals("Valami") && password.equals("Valami")){ //adatbázis kapcsolat IDE
            mylog.logger.info("Sikeres bejelentkezés! (" + username + ") ");
            return true;
        }
        else{
            mylog.logger.info("Sikertelen bejelentkezés! (" + username + ") ");
            return false;
        }
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
