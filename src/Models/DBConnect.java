package Models;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import Logger.Log;

import javax.swing.table.DefaultTableModel;

public class DBConnect {
    Log mylog = new Log("logs.txt");
    public Connection connection;
    public Statement statement;
    public ResultSet resultSet;
    public DBConnect() throws IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/progtech?useTimezone=true&serverTimezone=UTC","root","");
            statement = connection.createStatement();
        }catch (Exception ex){
            mylog.logger.info("Hiba az adatbázis kapcsolat során. A hiba oka:" + ex);
        }
    }

    /**
     * Frissiti az adatokat
     * @param model visszaadja újra a modelt
     */
    public void GetData(DefaultTableModel model){
        ArrayList<Order> list = ListData();
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getUsername();
            row[1] = list.get(i).getSelecteddrink();
            row[2] = list.get(i).getProcess();
            row[3] = list.get(i).getPrice();
            model.addRow(row);
        }
    }

    /**
     * Frissiti az adatokat + hozzateszi az ID-t
     * @param model visszaadja újra a modelt
     */
    public void GetData2(DefaultTableModel model){
        ArrayList<Order> list = ListData();
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getID();
            row[1] = list.get(i).getUsername();
            row[2] = list.get(i).getSelecteddrink();
            row[3] = list.get(i).getProcess();
            row[4] = list.get(i).getPrice();
            model.addRow(row);
        }
    }

    /**
     * Listába teszi az egész adatot
     * @return visszatér egy listával
     */
    public ArrayList<Order> ListData(){
        ArrayList<Order> ordersList = new ArrayList<>();
        try {
            String query = "SELECT * FROM orders";
            resultSet = statement.executeQuery(query);
            Order order;
            while (resultSet.next()){
                order = new Order(  resultSet.getInt("ID"),
                                    resultSet.getString("username"),
                                    resultSet.getString("selecteddrink"),
                                    resultSet.getString("process"),
                                    resultSet.getInt("price")
                );
                ordersList.add(order);
            }
        }catch (Exception ex){
            mylog.logger.info("Hiba az adatbázis kapcsolat során. A hiba oka:" + ex);
        }
        return ordersList;
    }

    /**
     * Az adatbázisba beszúr egy új rendelést
     * @param fullname a nevét
     * @param selectdrink hogy mit rendelt
     * @param model és melyik modelbe adja ezt vissza
     */
    public void AddData(String fullname, String selectdrink, DefaultTableModel model){
        try {
            String query = "INSERT INTO orders(username, selecteddrink, process, price) values('"+ fullname +"','"+ selectdrink +"','Feldolgozás alatt.','100')";
            statement.executeUpdate(query);
            model.setRowCount(0);

        }catch (Exception ex){
            mylog.logger.info("Hiba az adatbázis kapcsolat során. A hiba oka:" + ex);
        }
    }

    /**
     * A Szállítók be tudják állítani hogy jelenleg hol álnak az adott megrendeléssel
     * @param process milyen folyamatban van
     * @param id melyik azonosító
     * @param model milyen modelt adjon vissza
     */
    public void UpdateProcessData(String process, int id, DefaultTableModel model){
        try {
            String query =  "UPDATE `orders` SET `process` = '"+ process +"' WHERE `orders`.`id` = "+ id +";";
            statement.executeUpdate(query);
            model.setRowCount(0);

        }catch (Exception ex){
            mylog.logger.info("Hiba az adatbázis kapcsolat során. A hiba oka:" + ex);
        }
    }

    /**
     * Megnézi hogy a bejelentkező személy felhasználó e
     * @param username felhasználónév
     * @param password jelszó
     * @return visszatér egy logikai tipussal (igaz ha beléphet, hamis ha nem)
     */
    public boolean IsUser(String username, String password){
        try {
            String query = "select username, password from users where username='"+ username +"' AND password='"+ password +"'";
            resultSet = statement.executeQuery(query);
            return resultSet.next();
        }catch (Exception ex){
            mylog.logger.info("Hiba az adatbázis kapcsolat során. A hiba oka:" + ex);
        }
        return false;
    }
}
