import entities.Carrinho;

public class Main {
    public static void main(String[] args) {

        Carrinho carrinho = new Carrinho();
        carrinho.setId(1);
        carrinho.setItem("impressora Epson lx300");
        carrinho.setQuantidade(2);
        carrinho.setValor(699.0);
        carrinho.setPromo(false);

        // Chamando o método sem parametros
        System.out.println("Valor total do item: " + carrinho.calculaTotalItem());

        // Chamando parametro COM todos os metodos
        carrinho.alterarValorItem(799.0);
        System.out.println("Valor total do item: " + carrinho.calculaTotalItem());


    }
}