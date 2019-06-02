package Template;

import javax.swing.*;

public class GyumolcsTea extends Tea {
    @Override
    protected void FiltertRak(JTextArea szoveg) {
        szoveg.append("A forró vízbe gyümölcsöt rak\n");
    }

    @Override
    protected void CukrotRakBele(JTextArea szoveg){
        szoveg.append("Cukorral ízesíti\n");
    }
    @Override
    protected void CitromletRakBele(JTextArea szoveg){
        szoveg.append("Citromlével ízesíti\n");
    }

    @Override
    protected void Kiontes(JTextArea szoveg) {
        szoveg.append("Csészébe önti a gyümölcs teát\n");
    }

    @Override
    protected void Felszolgal(JTextArea szoveg){
        szoveg.append("Felszolgálja a gyümölcs teát\n");
    }
}
