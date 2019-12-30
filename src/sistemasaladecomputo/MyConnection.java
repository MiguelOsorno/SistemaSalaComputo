package sistemasaladecomputo;
import java.sql.Connection;
import java.sql.DriverManager;
public class MyConnection {
    public static Connection getConnection(){
        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost/SalaComputo", "rootmiguel", "2019Miguel10");
        } catch(Exception e) {
            System.out.print(e.getMessage());
        }
        
        return c;
    }
}
