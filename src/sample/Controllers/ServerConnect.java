package sample.Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ServerConnect {
    private final static String DBURL = "jdbc:mysql://46.242.246.219:3306";
    private final static String DBUSER = "30712964_test";
    private final static String DBPASS = "Passwordes123";
    private final static String DBDRIVER = "com.mysql.jdbc.Driver";
     Connection connection;


    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        return conn;
    }
    public void DBConnect(){


        try {
            Class.forName(DBDRIVER);
            connection = getConnection();
            Statement statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println();
            e.printStackTrace();
        }

        System.out.println("Polaczone");
    }
}
