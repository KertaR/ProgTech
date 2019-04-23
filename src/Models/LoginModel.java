package Models;

import Views.CustomerView;

public class LoginModel {
    public boolean IsUser(String username, String password){
        if (username.equals("Valami") && password.equals("Valami")){ //adatbázis kapcsolat IDE
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Átirányítás
     */
    public void Redirecting(){
        CustomerView cv = new CustomerView();
        cv.setVisible(true);
    }
}
