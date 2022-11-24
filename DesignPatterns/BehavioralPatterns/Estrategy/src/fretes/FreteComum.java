package fretes;

// na interface se utiliza IMPLEMENTS ao invéz de EXTENDS(herança)


import entities.Frete;

public class FreteComum implements Frete {


    @Override
    public double calcular(double valor) {
        return valor * 0.05;
    }


}
