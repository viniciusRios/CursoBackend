package entities;

import java.util.Objects;

public class ContaCorrente {

    private int id;
    private int agencia;
    private int numero;
    private String titular;
    private Double saldo;
    private Double limite;




    public ContaCorrente() {
    }
    public ContaCorrente(int id, int agencia, int numero, String titular, Double saldo, Double limite) {
        this.id = id;
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.limite = limite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    //Métodos customizados
    public void depositar(double valor){
        saldo = saldo + valor;
    }
    public void sacar    (double valor){
        saldo = saldo - valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaCorrente that = (ContaCorrente) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "id=" + id +
                ", agencia=" + agencia +
                ", numero=" + numero +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", limite=" + limite +
                '}';
    }

}
