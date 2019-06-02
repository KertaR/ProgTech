package Template;

import javax.swing.*;

public class FeketeTea extends Tea {
    @Override
    protected void FiltertRak(JTextArea szoveg) {
        szoveg.append("A forró vízbe filtert rak\n");
    }

    @Override
    protected void Kiontes(JTextArea szoveg) {
        szoveg.append("Csészébe önti a fekete teát\n");
    }

    @Override
    protected void Felszolgal(JTextArea szoveg){
        szoveg.append("Felszolgálja a fekete teát\n");
    }
}
