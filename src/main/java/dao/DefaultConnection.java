package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DefaultConnection {
    public final static String LOGIN = "postgres";
    public final static String PASSWORD = "12332112";
    public final static String URL = "jdbc:postgresql://localhost:5432/cars_depot";
    public static Connection ConnectToDatabase() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            System.out.format("Connection established with %s\n", connection.getCatalog());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
//        finally {
//            if(connection != null){
//                try {
//                    connection.close();
//                } catch (SQLException exception) {
//                    exception.printStackTrace();
//                }
//            }
//        }
        return connection;
    }
}
