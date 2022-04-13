
package cruds;

import controller.daoProfessor;
import enums.Sexos;
import enums.Titulacoes;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Professor;

public class crudProfessor {
    public static void main(String[] args) {
        daoProfessor dao = new daoProfessor();
        
        Professor professor = new Professor(0, "Alexandre Goes", LocalDate.of(2000, 2, 12), Sexos.M, Titulacoes.E);
        Professor professor1 = new Professor(0, "Maria Joana", LocalDate.of(1999, 3, 10), Sexos.F, Titulacoes.E);

        
        try {
            // System.out.println("Inserido " + dao.create(professor));
            // System.out.println("Inserido " + dao.create(professor1));
            
            //System.out.println("Editado "+ dao.update(0, "Luiz Gonzaga", LocalDate.of(1900, 5, 01), Sexos.M, Titulacoes.P, 0));
            
            Professor p = dao.read(3);
            if(p==null){
                System.out.println("Não localizado");
            }else{
                System.out.println("id = " + p.getId() +" .Nome = "+p.getNome());
            }
            
        } catch (SQLException ex) {
            System.out.println("ERRO" +ex.getMessage());
        }
        
    }
}
