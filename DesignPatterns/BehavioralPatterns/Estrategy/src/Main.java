import entities.Pedido;
import entities.PedidoBazar;
import entities.PedidoEletro;

public class Main {

    public static void main(String[] args)throws Exception {


        Pedido pe = new PedidoEletro(1000.00, "DVD");

        System.out.println("Pedido do setor de ELETRO: ");
        System.out.println("Valor do frete comum R$: " + pe.calcFreteComum());
        System.out.println("Valor do frete EXPRESSO R$: " + pe.calcFreteExpresso());

        Pedido pb = new PedidoBazar(1000.00, "Faqueiro");

        System.out.println("Pedido do setor de BAZAR: ");
        System.out.println("Valor do frete comum R$: " + pe.calcFreteComum());
        System.out.println("Valor do frete EXPRESSO R$: " + pe.calcFreteExpresso());

    }
}