
package model;

public class Disciplina implements java.io.Serializable {
    private int id;
    private String nome;
    private int fase;
    private Curso curso;
    private Professor professor;
    //
    public Disciplina(){
        this.setId(0);
        this.setNome("noname");
        this.setFase(1);
        this.setCurso(null);
        this.setProfessor(null);
    }
    public Disciplina(int id, String nome, int fase, Curso curso, Professor professor){
        this.setId(id);
        this.setNome(nome);
        this.setFase(fase);
        this.setCurso(curso);
        this.setProfessor(professor);
    }
    //
    public void setId(int id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome.trim().isEmpty()?"NONAME":nome.toUpperCase();
    }
    public void setFase(int fase){
        this.fase = (fase<1)||(fase>12)?1:fase;
    }
    public void setCurso(Curso curso){
        this.curso = curso==null ? new Curso() : curso;
    }
    public void setProfessor(Professor professor){
        this.professor = professor==null ? new Professor() : professor;
    }
    //
    public int getId() {
        return this.id;
    }
    public String getNome() {
        return this.nome;
    }

    public int getFase() {
        return this.fase;
    }

    public Curso getCurso() {
        return this.curso;
    }

    public Professor getProfessor() {
        return this.professor;
    }
    //
    @Override
    public String toString(){
        return this.nome;
    }
    //
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disciplina other = (Disciplina) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }    
}
