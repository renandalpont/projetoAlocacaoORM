
package abstratas;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

abstract public class metodosDAO {
    //PreparedStatement
    public PreparedStatement getStatement(String SQL) throws SQLException{
        return Dados.getConnection().prepareStatement(SQL);
    }
    //
    //UPDATE
    public int executeUpdate(String SQL, Object... args) throws SQLException{ //SQL
        //PreparedStatement
        PreparedStatement pst = this.getStatement(SQL);
        //Parametros
        for (int i = 0; i < args.length; i++) {
            pst.setObject((i+1), args[i]);
        }
        //execute
        return pst.executeUpdate();
    }
    //
    //QUERY
    public ResultSet executeQuery(String SQL, Object... args) throws SQLException{ //SQL
        //PreparedStatement
        PreparedStatement pst = this.getStatement(SQL);
        //Parametros
        for (int i = 0; i < args.length; i++) {
            pst.setObject((i+1), args[i]);
        }
        //execute
        return pst.executeQuery();
    }
}
