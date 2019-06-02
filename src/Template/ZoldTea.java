package Template;

import javax.swing.*;

public class ZoldTea extends Tea {
    @Override
    protected void FiltertRak(JTextArea szoveg) {
        szoveg.append("A forró vízbe növényt rak\n");
    }

    @Override
    protected void CitromletRakBele(JTextArea szoveg){
        szoveg.append("Citromlével ízesíti\n");
    }

    @Override
    protected void Kiontes(JTextArea szoveg) {
        szoveg.append("Pohárba önti a zöld teát\n");
    }

    @Override
    protected void Felszolgal(JTextArea szoveg){
        szoveg.append("Felszolgálja a zöld teát\n");
    }
}
