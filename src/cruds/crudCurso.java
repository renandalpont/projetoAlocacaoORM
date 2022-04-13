
package cruds;

import controller.daoCurso;
import controller.daoProfessor;
import enums.Turnos;
import java.sql.SQLException;
import model.Curso;

public class crudCurso {
    public static void main(String[] args) {
        try{
            Curso c1 = new Curso(0, "adm", Turnos.M, new daoProfessor().read(4), 0);
            daoCurso dao = new daoCurso();
            //System.out.println(dao.create(c1));
            for(Curso curso : dao.read()){
                System.out.println(curso.getNome() + "\t"
                                  + curso.getCoordenador().getNome());
            }
        }catch(SQLException ex){
            System.out.println("ERRO "+ ex.getMessage());
        }
        
    }
}
