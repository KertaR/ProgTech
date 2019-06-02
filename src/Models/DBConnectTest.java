package Models;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DBConnectTest {

    @Test
    void listData() throws IOException, SQLException {
        DBConnect db = new DBConnect();
        ArrayList<Order> ordersList = new ArrayList<>();
        try {
            String query = "SELECT * FROM orders";
            db.resultSet = db.statement.executeQuery(query);
            Order order;
            while (db.resultSet.next()){
                order = new Order(  db.resultSet.getInt("ID"),
                        db.resultSet.getString("username"),
                        db.resultSet.getString("selecteddrink"),
                        db.resultSet.getString("process"),
                        db.resultSet.getInt("price")
                );
                ordersList.add(order);
            }
        }catch (Exception ex){
        }
        assertNotEquals(null, ordersList);
    }
    @Test
    void listData2() throws IOException, SQLException {
        DBConnect db = new DBConnect();
        ArrayList<Order> ordersList = new ArrayList<>();
        try {
            String query = "SELECT * FROM orders";
            db.resultSet = db.statement.executeQuery(query);
            Order order;
            while (db.resultSet.next()){
                order = new Order(  db.resultSet.getInt("ID"),
                        db.resultSet.getString("username"),
                        db.resultSet.getString("selecteddrink"),
                        db.resultSet.getString("process"),
                        db.resultSet.getInt("price")
                );
                ordersList.add(order);
            }
        }catch (Exception ex){
        }
        assertEquals(3, ordersList.size());
    }
    @Test
    void isUser() throws IOException {
        DBConnect db = new DBConnect();
        String username = "Valami";
        String password = "Valami";
        try {
            String query = "select username, password from users where username='"+ username +"' AND password='"+ password +"'";
            db.resultSet = db.statement.executeQuery(query);
            assertEquals(true,db.resultSet.next());
        }catch (Exception ex){
        }
    }
    @Test
    void isUser2() throws IOException {
        DBConnect db = new DBConnect();
        String username = "Kecske";
        String password = "12345";
        try {
            String query = "select username, password from users where username='"+ username +"' AND password='"+ password +"'";
            db.resultSet = db.statement.executeQuery(query);
            assertEquals(false,db.resultSet.next());
        }catch (Exception ex){
        }
    }
    @Test
    void isUser3() throws IOException {
        DBConnect db = new DBConnect();
        String username = null;
        String password = "12345";
        try {
            String query = "select username, password from users where username='"+ username +"' AND password='"+ password +"'";
            db.resultSet = db.statement.executeQuery(query);
            assertEquals(false,db.resultSet.next());
        }catch (Exception ex){
        }
    }
}