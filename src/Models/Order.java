package Models;

public class Order {

    private int ID;
    private String username;
    private String selecteddrink;
    private String process;
    private int price;

    public String getUsername() {
        return username;
    }
    public int getID() {
        return ID;
    }

    public String getSelecteddrink() {
        return selecteddrink;
    }

    public String getProcess() {
        return process;
    }

    public int getPrice() {
        return price;
    }

    public Order(int ID, String username, String selecteddrink, String process, int price){
        this.ID = ID;
        this.username = username;
        this.selecteddrink = selecteddrink;
        this.process = process;
        this.price = price;
    }
}
