package fretes;

// na interface se utiliza IMPLEMENTS ao invéz de EXTENDS(herança)


import entities.Frete;

public class FretePrime implements Frete {


    @Override
    public double calcular(double valor) {
        return 0.0; //frete gratuito
    }


}
