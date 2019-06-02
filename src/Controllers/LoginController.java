package Controllers;

import Models.LoginModel;
import Views.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginController {
    private LoginView view;
    private LoginModel model;

    public LoginController(LoginView view, LoginModel model)
    {
        this.view = view;
        this.model = model;
        view.BejelentkezesActionListener(new BejelentkezesListener());
        view.DeliveryBejelentkezesActionListener(new DeliveryBejelentkezesListener());
    }

    class BejelentkezesListener implements ActionListener
    {
        /**
         * Ha sikerül a bejelentkezés akkor átírányítja a másik felületre
         * @param ae
         */
        @Override
        public void actionPerformed(ActionEvent ae) {
            String username,password = "";

            username = view.GetUsername();
            password = view.GetPassword();

            if (model.IsUser(username,password)){
                try {
                    model.Redirecting();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    class DeliveryBejelentkezesListener implements ActionListener
    {
        /**
         * Ha sikerül a bejelentkezés akkor átírányítja a másik felületre
         * @param ae
         */
        @Override
        public void actionPerformed(ActionEvent ae) {
            String username,password = "";

            username = view.GetUsername();
            password = view.GetPassword();

            if (model.IsUser(username,password)){
                try {
                    model.DeliveryRedirecting();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
