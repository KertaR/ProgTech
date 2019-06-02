package Decorator;

public class Cukor extends TeaDiszito {
    public Cukor(Tea tea) {
        super(tea);
    }
    @Override
    public int GetMin(){
        return super.GetMin() + 1;
    }
    @Override
    public String GetHozzavalok(){
        return super.GetHozzavalok() + "Cukor, ";
    }
}
