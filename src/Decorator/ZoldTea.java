package Decorator;

public class ZoldTea extends Tea {
    @Override
    public int GetMin() {
        return 7;
    }

    @Override
    public String GetHozzavalok() {
        return "Víz, növény, ";
    }
}
