package Decorator;

public class GyumolcsTea extends Tea {
    @Override
    public int GetMin() {
        return 5;
    }

    @Override
    public String GetHozzavalok() {
        return "Víz, gyümölcs, ";
    }
}
