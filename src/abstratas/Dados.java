
package abstratas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class Dados {
    private static Connection connection=null; //instanciando a conecção
    
    public static Connection getConnection() throws SQLException{
        if(connection==null){
            String url="jdbc:postgresql://localhost:5432/alocacao";
            String usr="postgres";
            String pwd="admin";
            connection = DriverManager.getConnection(url, usr, pwd);            
        }
        return connection;
    }
}
