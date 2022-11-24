package entities;

import entities.types.Boleto10d;
import entities.types.Boleto30d;
import entities.types.Boleto60d;

public class Banco {

    //para acessar o método criarBoleto no simple factory
    private BoletoSimpleFactory boletoSimpleFactory;

    public Banco(BoletoSimpleFactory boletoSimpleFactory) {
        this.boletoSimpleFactory = boletoSimpleFactory;
    }

    public Boleto gerarBoleto(int venc, double valor) throws Exception {

          Boleto boleto = this.boletoSimpleFactory.criarBoleto(venc, valor);


            System.out.println("Valor do boleto Gerado: "+ valor);
            System.out.println("Valor do juros: "+ boleto.calcularJuro());
            System.out.println("Valor do desconto: "+ boleto.calcularDesconto());
            System.out.println("Valor da Multa: " + boleto.calcularMulta());
            System.out.println("============================================");

            return boleto;
        }
}
