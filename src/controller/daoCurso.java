
package controller;

import abstratas.metodosDAO;
import enums.Turnos;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import model.Curso;


public class daoCurso extends metodosDAO{
    public int create(Curso curso) throws SQLException{
        String SQL="insert into curso (nome, turno, id_coordenador, carga)"
                + "values (?, ?, ?, ?)";
        return super.executeUpdate(SQL, curso.getNome(),
                                        curso.getTurno().name(),
                                        curso.getCoordenador().getId(),
                                        curso.getCarga());
    }
    public int update(Curso curso) throws SQLException{
        String SQL="update curso set nome=?,turno=?,id_coordenador=?,carga=?"
                + "where id=?";
        return super.executeUpdate(SQL, curso.getNome(),
                                        curso.getTurno().name(),
                                        curso.getCoordenador().getId(),
                                        curso.getCarga(),
                                        curso.getId());
    }
    public int delete(Curso curso) throws SQLException{
        //SQL + PARAMETRO
        //String SQL = "delete from professor where id="+ curso.getId();
        //PARAMETRO
        //return super.executeUpdate(SQL, curso.getId());
        //
        // EXECUÇÃO EM UMA LINHA
        return super.executeUpdate("delete from curso where id="+curso.getId());
    }
    //SELECT UNICO
    public Curso read(int id) throws SQLException{
        //SQL + PARAMETRO
        String SQL = "select * from curso where id="+id;
        //PREPAREDSTATEMENT 
        ResultSet rs = super.executeQuery(SQL);
        //SSE MEU OBJETO EXISTE EU DEVOLVO SENÃO DEVOLVO NULO + EXECUÇÃO
        return (rs.next() ? createCurso(rs) : null);
    }
    //SELECT GERAL TABELA
    public List<Curso> read() throws SQLException{
        //SQL + PARAMETRO
        String SQL = "select * from curso order by curso.nome";
        //PREPAREDSTATEMENT 
        ResultSet rs = super.executeQuery(SQL);
        //INSTANCIANDO MINHA LISTA
        List<Curso> retorno = new LinkedList<Curso>();
        //SSE MEU OBJETO EXISTE EU DEVOLVO SENÃO DEVOLVO NULO + EXECUÇÃO
        while(rs.next()){
            retorno.add(createCurso(rs));
        }
        return retorno;
    }
    //
    //
    private Curso createCurso(ResultSet rs) throws SQLException{
        return new Curso(
                rs.getInt("id"),
                rs.getString("nome"),
                Turnos.valueOf(rs.getString("turno")),
                new daoProfessor().read(rs.getInt("id_coordenador")),
                rs.getInt("carga"));
    }
}
