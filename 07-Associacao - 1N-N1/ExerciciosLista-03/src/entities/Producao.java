package entities;

public class Producao extends Funcionario {

    private int tempoExperiencia;


    public Producao() {
    }

    public Producao(int id, String nome, String sobrenome, String cpf, Endereco endereco, int tempoExperiencia) {
        super(id, nome, sobrenome, cpf, endereco);
        this.tempoExperiencia = tempoExperiencia;
    }

    public int getTempoExperiencia() {
        return tempoExperiencia;
    }

    public void setTempoExperiencia(int tempoExperiencia) {
        this.tempoExperiencia = tempoExperiencia;
    }

    @Override
    public String toString() {
        return "Producao{" +
                "tempoExperiencia=" + tempoExperiencia +
                "} " + super.toString();
    }
}
