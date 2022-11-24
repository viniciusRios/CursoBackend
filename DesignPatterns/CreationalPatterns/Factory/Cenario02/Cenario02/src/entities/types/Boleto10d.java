package entities.types;

import entities.Boleto;

public class Boleto10d extends Boleto {

    public Boleto10d(double valor){
        super(valor);
        this.juro = 0.01;
        this.desconto = 0.01;
        this.multa = 0.01;
    }
}
