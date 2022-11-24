package entities.types;

import entities.Boleto;

public class Boleto30d extends Boleto {

    public Boleto30d(double valor){
        super(valor);
        this.juro = 0.03;
        this.desconto = 0.03;
        this.multa = 0.03;
    }

}
