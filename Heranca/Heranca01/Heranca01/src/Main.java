import entities.ContaPF;
import entities.ContaPJ;
import entities.ContaUni;

public class Main {
    public static void main(String[] args) {

        ContaPF pf1 = new ContaPF(1, 2255, 25410, "João batista", 0.0, 200.0, "01624737021");


        System.out.println("Conta PESSOA FISICA");
        System.out.println("ID "+pf1.getId());
        System.out.println("Ag. "+pf1.getAgencia());
        System.out.println("Numero: "+pf1.getNumero());
        System.out.println("Titular: "+pf1.getTitular());
        System.out.println("Saldo: "+pf1.getSaldo());
        System.out.println("Limite: "+pf1.getLimite());
        System.out.println("Cpf: "+pf1.getCpf());

        //Conta pessoa juridica
        ContaPJ pj1 = new ContaPJ(2, 2222, 222222, "Programador PJ", 0.0, 1000.00, "11.254.569/0001-58");

        System.out.println("Conta Pessoa Juridica");
        System.out.println("ID "+pj1.getId());
        System.out.println("Ag. "+pj1.getAgencia());
        System.out.println("Numero: "+pj1.getNumero());
        System.out.println("Titular: "+pj1.getTitular());
        System.out.println("Saldo: "+pj1.getSaldo());
        System.out.println("Limite: "+pj1.getLimite());
        System.out.println("CNPJ" + pj1.getCnpj());

        //Conta universitario
        ContaUni Uni1 = new ContaUni(3, 3333, 333333, "Universitario", 0.0, 100.00, "304050");

        System.out.println("Conta Universitario");
        System.out.println("ID "+Uni1.getId());
        System.out.println("Ag. "+Uni1.getAgencia());
        System.out.println("Numero: "+Uni1.getNumero());
        System.out.println("Titular: "+Uni1.getTitular());
        System.out.println("Saldo: "+Uni1.getSaldo());
        System.out.println("Limite: "+Uni1.getLimite());
        System.out.println("Matricula: " + Uni1.getMatricula());


    }

}
