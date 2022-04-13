
package enums;

public enum Titulacoes {
    G("Graduação"),
    E("Especialização"),
    M("Mestrado"),
    D("Doutorado"),
    P("Pós-Doc");
    //
    private String descricao;
    //alt+ins
    private Titulacoes(String descricao) {
        this.descricao = descricao;
    }
    //
    @Override
    public String toString(){
        return descricao;    
    }
}
