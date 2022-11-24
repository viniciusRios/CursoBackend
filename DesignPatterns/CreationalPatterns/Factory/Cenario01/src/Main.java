import entities.Banco;

public class Main {


    public static void main(String[] args) {


        Banco banco = new Banco();
        banco.gerarBoleto(10, 1000.00);
        banco.gerarBoleto(30, 1000.00);
        banco.gerarBoleto(60, 1000.00);




    }
}