import dao.DefaultConnection;

import java.sql.Connection;
import java.util.Collection;

public class MainApp {
    public static void main(String[] args) {
        Connection connectioToCarsDepot = DefaultConnection.ConnectToDatabase();
    }
}
