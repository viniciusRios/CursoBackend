import entities.Pedido;
import entities.PedidoBazar;
import entities.PedidoEletro;
import fretes.FreteComum;
import fretes.FreteExpresso;
import fretes.FretePJ;
import fretes.FretePrime;

public class Main {

    public static void main(String[] args) throws Exception {

        FreteComum freteComum = new FreteComum();
        FreteExpresso freteExpresso = new FreteExpresso();
        FretePrime fretePrime = new FretePrime();
        FretePJ fretePJ = new FretePJ();

        Pedido pe = new PedidoEletro(1000.0, "DVD");
        System.out.println("Pedido do setor eletro");
        pe.setTipoFrete(freteComum);
        System.out.println("Frete comum: R$"+ pe.calcularFrete());

        Pedido pe2 = new PedidoEletro(1000.0, "DVD");
        System.out.println("Pedido do setor eletro 2");
        pe2.setTipoFrete(freteExpresso);
        System.out.println("Frete expresso: R$"+ pe2.calcularFrete());

        Pedido pe3 = new PedidoEletro(1000.0, "DVD");
        System.out.println("Pedido do setor eletro 3");
        pe3.setTipoFrete(fretePJ);
        System.out.println("Frete PJ: R$"+ pe3.calcularFrete());

        Pedido pe4 = new PedidoEletro(1000.0, "DVD");
        System.out.println("Pedido do setor eletro 4");
        pe4.setTipoFrete(fretePrime);
        System.out.println("Frete Prime: R$"+ pe4.calcularFrete());



    }
}