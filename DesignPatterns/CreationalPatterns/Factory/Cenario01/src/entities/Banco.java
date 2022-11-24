package entities;

import entities.types.Boleto10d;
import entities.types.Boleto30d;
import entities.types.Boleto60d;

public class Banco {

        public Boleto gerarBoleto(int venc, double valor){

            Boleto boleto = null;

            switch (venc){
                case 10:
                    boleto = new Boleto10d(valor);
                    break;
                case 30:
                    boleto = new Boleto30d(valor);
                    break;
                case 60:
                    boleto = new Boleto60d(valor);
                    break;
                default:
                    //Lança uma exception no default

            }


            System.out.println("Valor do boleto Gerado: "+ valor);
            System.out.println("Valor do juros: "+ boleto.calcularJuro());
            System.out.println("Valor do desconto: "+ boleto.calcularDesconto());
            System.out.println("Valor da Multa: " + boleto.calcularMulta());
            System.out.println("============================================");
            return boleto;
        }
}
