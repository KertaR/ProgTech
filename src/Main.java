import Controllers.LoginController;
import Models.LoginModel;
import Views.LoginView;

public class Main {
    public static void main(String[] args) {
        LoginView lv = new LoginView();
        LoginModel lm = new LoginModel();
        LoginController lc = new LoginController(lv, lm);
        lv.setVisible(true);
    }
}
