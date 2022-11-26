package entities;

public class RecursosHumanos extends Funcionario{

    private int metaAlcancada;

    public RecursosHumanos() {
    }

    public RecursosHumanos(int id, String nome, String sobrenome, String cpf, Endereco endereco, int metaAlcancada) {
        super(id, nome, sobrenome, cpf, endereco);
        this.metaAlcancada = metaAlcancada;
    }

    public int getMetaAlcancada() {
        return metaAlcancada;
    }

    public void setMetaAlcancada(int metaAlcancada) {
        this.metaAlcancada = metaAlcancada;
    }

    //Metodos customizados
    public void trabalhar(){

    }

    @Override
    public String toString() {
        return "RecursosHumanos{" +
                "metaAlcancada=" + metaAlcancada +
                "} " + super.toString();
    }
}
