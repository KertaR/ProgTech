package Decorator;

public class FeketeTea extends Tea {
    @Override
    public int GetMin() {
        return 6;
    }

    @Override
    public String GetHozzavalok() {
        return "Víz, filter";
    }
}
