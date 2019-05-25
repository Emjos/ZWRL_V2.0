package sample.Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ServerConnect {
    private final static String DBURL = "jdbc:mysql://localhost:3307/users";
    private final static String DBUSER = "root";
    private final static String DBPASS = "Password1";
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
