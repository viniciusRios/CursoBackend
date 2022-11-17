package entities;

import java.util.Objects;

public class ContaUni extends ContaCorrente{

    private String matricula;

    public ContaUni(int id, int agencia, int numero, String titular, Double saldo, Double limite, String matricula) {
        super(id, agencia, numero, titular, saldo, limite);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ContaUni contaUni = (ContaUni) o;
        return Objects.equals(matricula, contaUni.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), matricula);
    }

    @Override
    public String toString() {
        return super.toString() +
                "ContaUni{" +
                "matricula='" + matricula + '\'' +
                '}';
    }
}
