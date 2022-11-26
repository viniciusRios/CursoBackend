package entities;

import java.util.Objects;

public class ContaPJ extends ContaCorrente{

        private String cnpj;

    public ContaPJ(int id, int agencia, int numero, String titular, Double saldo, Double limite, String cnpj) {
        super(id, agencia, numero, titular, saldo, limite);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ContaPJ contaPJ = (ContaPJ) o;
        return Objects.equals(cnpj, contaPJ.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cnpj);
    }

    @Override
    public String toString() {
        return  super.toString() +
                "ContaPJ{" +
                "cnpj='" + cnpj + '\'' +
                '}';
    }
}
