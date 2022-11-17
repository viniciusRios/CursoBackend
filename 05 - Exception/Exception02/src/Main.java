import entities.Cliente;
import exceptions.ClienteException;


public class Main {

    public static void main(String[] args) {

        Cliente c1 = new Cliente("Michele", "Pinheiro", "90520330", 0.0);


        try{
            System.out.println("Saldo inicial: " + c1.getSaldoEmConta());
            c1.depositar(500.00);
            c1.depositar(1000.00);
            c1.comprar(250.00);
            c1.atualizarLimite(1500.00);
            c1.contrairDivida(2000.00);
            c1.pagarDivida(1500.00);
        }

        catch (ClienteException cli ){
            System.err.println(cli);
        }
        finally{
            System.out.println("\n programa finalizado");
        }




    }
}