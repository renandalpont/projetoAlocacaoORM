
package controller;

import abstratas.Dados;
import enums.Sexos;
import enums.Titulacoes;
import model.Professor;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.naming.spi.DirStateFactory;
import java.sql.ResultSet;

public class daoProfessor {
    public int create(Professor professor) throws SQLException{
        // 1-SQL
       String SQL="insert into professor(nome, nascimento, sexo, titulacao) values (?,?,?,?)"; 
       // 2-PreparedStatement
       PreparedStatement pst = Dados.getConnection().prepareStatement(SQL);
       // 3-Parâmetros
       pst.setString(1, professor.getNome());
       pst.setObject(2, professor.getNascimento());
       pst.setObject(3, professor.getSexo().name());
       pst.setObject(4, professor.getTitulacao().name());
       // 4-Executar
       return pst.executeUpdate();
    }
    public int update(Professor professor) throws SQLException{
        //
        String SQL="update professor set nome=?, nascimento=?, sexo=?, titulacao=? where id=?";
        //
        PreparedStatement pst = Dados.getConnection().prepareStatement(SQL);
        //
        pst.setObject(1, professor.getNome());
        pst.setObject(2, professor.getNascimento());
        pst.setObject(3, professor.getSexo().name());
        pst.setObject(4, professor.getTitulacao().name());
        pst.setObject(5, professor.getId());
        //
        return pst.executeUpdate();
    }
    //
    public int delete(Professor professor) throws SQLException{
        //SQL + PARAMETRO
        String SQL = "delete from professor where id="+ professor.getId();
        //
        PreparedStatement pst = Dados.getConnection().prepareStatement(SQL);
        //
        return pst.executeUpdate();
    }
    //
    public String update(int i, String luiz_Gonzaga, LocalDate of, Sexos sexos, Titulacoes titulacoes, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //
    public Professor read(int id) throws SQLException{
        String SQL="select * from professor where id="+id;
        //
        PreparedStatement pst = Dados.getConnection().prepareStatement(SQL);
        //
        ResultSet rs = pst.executeQuery();
        return rs.next() ? createProfessor(rs) : null;
    }
    //
    private Professor createProfessor(ResultSet rs) throws SQLException{
        return new Professor(rs.getInt("id"), rs.getString("Nome"), rs.getDate("nascimento").toLocalDate(), Sexos.valueOf(rs.getString("sexo")),Titulacoes.valueOf(rs.getString("titulacao")));
        
    }
}
