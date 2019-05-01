package Models;

import java.io.IOException;
import java.sql.*;
import Logger.Log;

public class DBConnect {
    Log mylog = new Log("logs.txt");
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    public DBConnect() throws IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/progtech?useTimezone=true&serverTimezone=UTC","root","");
            statement = connection.createStatement();
        }catch (Exception ex){
            mylog.logger.info("Hiba az adatbázis kapcsolat során. A hiba oka:" + ex);
        }
    }
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
