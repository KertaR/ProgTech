package Template;
import Views.DeliveryView;
import javax.swing.*;

public abstract class Tea {
    private DeliveryView view = new DeliveryView();
    public void Elkeszit(JTextArea szoveg){
        VizetForral(szoveg);
        FiltertRak(szoveg);
        CukrotRakBele(szoveg);
        CitromletRakBele(szoveg);
        Varakozas(szoveg);
        Kiontes(szoveg);
        Felszolgal(szoveg);
    }
    private void VizetForral(JTextArea szoveg){
        szoveg.setText("A teához vizet forral\n");

    }
    protected abstract void FiltertRak(JTextArea szoveg);
    protected void CukrotRakBele(JTextArea szoveg){

    }
    protected void CitromletRakBele(JTextArea szoveg){

    }
    private void Varakozas(JTextArea szoveg){
        szoveg.append("Var míg kioldodik a filterbol a cucc\n");
    }
    protected abstract void Kiontes(JTextArea szoveg);
    protected void Felszolgal(JTextArea szoveg){

    }
}
