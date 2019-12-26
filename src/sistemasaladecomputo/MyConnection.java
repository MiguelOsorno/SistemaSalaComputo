/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasaladecomputo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Miguel
 */
public class MyConnection {
    public static Connection getConnection(){
        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost/SalaComputo", "rootmiguel", "");
        } catch(Exception e) {
            System.out.print(e.getMessage());
        }
        
        return c;
    }
}
