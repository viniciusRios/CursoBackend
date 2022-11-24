package entities.types;

import entities.Boleto;

public class Boleto60d extends Boleto {

    public Boleto60d(double valor){
        super(valor);
        this.juro = 0.06;
        this.desconto = 0.06;
        this.multa = 0.06;
    }
}
