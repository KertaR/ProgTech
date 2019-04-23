package Controllers;

import Models.LoginModel;
import Views.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private LoginView view;
    private LoginModel model;

    public LoginController(LoginView view, LoginModel model)
    {
        this.view = view;
        this.model = model;

        view.BejelentkezesActionListener(new BejelentkezesListener());
    }

    class BejelentkezesListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String username,password = "";

            username = view.GetUsername();
            password = view.GetPassword();

            if (model.IsUser(username,password)){
                model.Redirecting();
            }
        }

    }
}
