package Views;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField username;
    private JTextField password;
    private JButton btn_bejelentkezes;
    private JPanel rootpanel;
    private JButton btn_delivery;

    public LoginView() {
        add(rootpanel);
        setTitle("Bejelentkezés");
        setSize(300,150);
    }

    /**
     * Visszaadja a felhasználónevet
     * @return username
     */
    public String GetUsername()
    {
        return username.getText();
    }

    /**
     * Visszaadja a jelszavát
     * @return password
     */
    public String GetPassword()
    {
        return password.getText();
    }
    public void BejelentkezesActionListener(ActionListener listener)
    {
        this.btn_bejelentkezes.addActionListener(listener);
    }
    public void DeliveryBejelentkezesActionListener(ActionListener listener)
    {
        this.btn_delivery.addActionListener(listener);
    }
}
