
package enums;

public enum Turnos {
    M("Matutino"),
    V("Vespetino"),
    N("Noturno");
    //
    private String descricao;
    //alt+ins
    private Turnos(String descricao) {
        this.descricao = descricao;
    }
    //
    @Override
    public String toString(){
        return descricao;
    }
}
