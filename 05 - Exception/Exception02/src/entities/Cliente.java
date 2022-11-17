package entities;

import exceptions.ClienteException;

import java.util.Objects;

public class Cliente {

        private String nome;
        private String sobrenome;
        private String rg;
        private Double saldoEmConta = 1.0;
        private Double limite;
        private Double divida;



        public Cliente (){

        }

        public Cliente(String nome, String sobrenome, String rg, Double limite) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.rg = rg;
            this.saldoEmConta = 0.0;
            this.divida = 0.0;
            this.limite = limite;

        }

        public Cliente(String nome, String sobrenome, String rg, Double saldoEmConta, Double limite, Double divida) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.rg = rg;
            this.saldoEmConta = saldoEmConta;
            this.limite = limite;
            this.divida = divida;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getSobrenome() {
            return sobrenome;
        }

        public void setSobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
        }

        public String getRg() {
            return rg;
        }

        public void setRg(String rg) {
            this.rg = rg;
        }

        public Double getSaldoEmConta() {
            return saldoEmConta;
        }

        public void setSaldoEmConta(Double saldoEmConta) {
            this.saldoEmConta = saldoEmConta;
        }

        public Double getLimite() {
            return limite;
        }

        public void setLimite(Double limite) {
            this.limite = limite;
        }

        public Double getDivida() {
            return divida;
        }

        public void setDivida(Double divida) {
            this.divida = divida;
        }


        //metodos customizados
        public void depositar(Double valor) throws ClienteException {
            if(valor <= 0.0){
             throw new ClienteException("Valor Invalido para depósito! ");
            }else {
                saldoEmConta = saldoEmConta + valor;
                System.out.println("Saldo atualizado com depósito R$: "+saldoEmConta);
            }
        }


        public void comprar (Double valor) throws ClienteException{
            if(saldoEmConta + limite >= valor){
                saldoEmConta = saldoEmConta - valor;
                System.out.println("Saldo atualizado após a compra R$: "+saldoEmConta);
            }
            else {
                System.out.println("Saldo Insuficiente, operação não realizada ");
            }
        }

        public void atualizarLimite(Double valor) throws ClienteException{
            System.out.println("Limite anterior: R$" + limite);
            limite = valor;
            System.out.println("Limite atualizado para: "+ limite);
        }

        public void contrairDivida(Double valor) throws ClienteException{
            if(valor <= 0.0){
                throw new ClienteException("Valor invalido");
            } else {
                divida = divida + valor;
                System.out.println("Divida contraida" + divida);
            }

        }

        //metodo PagarDivida
        public void pagarDivida(Double valor) throws ClienteException{
            if(getDivida() >= valor){
                throw new ClienteException("Valor invalido");

            }else {
                divida = divida - valor;
                System.out.println("Novo valor da divida: " + divida);
            }

        }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nome, cliente.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", rg='" + rg + '\'' +
                ", saldoEmConta=" + saldoEmConta +
                ", limite=" + limite +
                ", divida=" + divida +
                '}';
    }


}
