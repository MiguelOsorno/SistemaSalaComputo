
package sistemasaladecomputo;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class conectar {
    private static Connection conn;
    private static final String driver= "com.mysql.cj.jdbc.Driver";
    private static final String user= "miguelosorno";
    private static final String password= "";
    private static final String url= "jdbc:mysql://localhost/salacomputo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    public conectar() throws Exception{
        conn=null;
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,password);
            if(conn!=null)
            {
                System.out.println("conexion establecida");
            }
        }catch (Exception e){
            throw new Exception ("Error al conectar con la base de datos:");
        }
        
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public void desconectar(){
        conn=null;
        if(conn==null){
            System.out.println("conexion terminada");
        }
    }
    
}
