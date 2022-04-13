
package model;

import enums.Sexos;
import enums.Titulacoes;
import java.time.LocalDate;

public class Professor implements java.io.Serializable {
    private int id;
    private String nome;
    private LocalDate nascimento;
    private Sexos sexo;
    private Titulacoes titulacao;
    //construtores
    public Professor(){
        this.setId(0);
        this.setNome("sem nome");
        this.setNascimento(LocalDate.now());
        this.setSexo(Sexos.F);
        this.setTitulacao(Titulacoes.G);
    }
    public Professor(int id, String nome,LocalDate nascimento,Sexos sexo,Titulacoes titulacao){
        this.setId(id);
        this.setNome(nome);
        this.setNascimento(nascimento);
        this.setSexo(sexo);
        this.setTitulacao(titulacao);
    }
    //
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty()?"NONAME":nome.toUpperCase();
    }
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento==null?LocalDate.now():nascimento;
    }
    public void setSexo(Sexos sexo) {
        this.sexo = sexo;
    }
    public void setTitulacao(Titulacoes titulacao) {
        this.titulacao = titulacao;
    }
    //
    public int getId() {
        return this.id;
    }
    public String getNome() {
        return this.nome;
    }
    public LocalDate getNascimento() {
        return this.nascimento;
    }
    public Sexos getSexo() {
        return this.sexo;
    }
    public Titulacoes getTitulacao() {
        return this.titulacao;
    }
    //
    @Override
    public String toString(){
        return this.nome;
    }
    //

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
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
        final Professor other = (Professor) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    } 
}
