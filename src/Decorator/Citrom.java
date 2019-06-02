package Decorator;

public class Citrom extends TeaDiszito {
    public Citrom(Tea tea) {
        super(tea);
    }
    @Override
    public int GetMin(){
        return super.GetMin() - 2;
    }
    @Override
    public String GetHozzavalok(){
        return super.GetHozzavalok() + "Citrom, ";
    }
}
