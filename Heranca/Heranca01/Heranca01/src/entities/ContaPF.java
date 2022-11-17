package entities;

public class ContaPF extends ContaCorrente { // extends trás toda a classe conta corrente pra acessar

    private String cpf;

    public ContaPF(int id, int agencia, int numero, String titular, Double saldo, Double limite, String cpf) {
        super(id, agencia, numero, titular, saldo, limite);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return  super.toString()+
                "ContaPF{" +
                "cpf='" + cpf + '\'' +
                '}';
    }
}
