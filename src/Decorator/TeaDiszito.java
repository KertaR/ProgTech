package Decorator;

public abstract class TeaDiszito extends Tea {
    private Tea tea;
    public int GetMin(){
        return tea.GetMin();
    }
    public String GetHozzavalok(){
        return tea.GetHozzavalok();
    }
    public TeaDiszito(Tea tea){
        this.tea = tea;
    }
}
