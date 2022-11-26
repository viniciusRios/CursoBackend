import entities.Celetista;
import entities.PessoaJuridica;
import entities.Professor;

public class Main {
    public static void main(String[] args) {

        Professor celetista = new Celetista(1L, "Paula", "PAULA@GMAIL.COM0");

        Double salCeletista = celetista.calcularSalario(4000.00, 11.0);
        System.out.println("Salario do professort celetista: R$" +  salCeletista);


        Professor pessoaJuridica = new PessoaJuridica(2l, "João");

    }
}