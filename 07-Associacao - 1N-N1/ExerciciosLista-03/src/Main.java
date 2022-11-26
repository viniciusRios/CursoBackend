import entities.*;

public class Main {
    public static void main(String[] args) {

        Endereco e1 = new Endereco(1, "R. rua","Numero x", "Cidade 1", "estado 1");


        System.out.println("MARKETING ");
        Marketing mk1 = new Marketing(1,"fulano mkt","da silva", "90520320", e1, "vendas" );

        System.out.println("ID: " + mk1.getId() );
        System.out.println("Nome: " + mk1.getNome() );
        System.out.println("Sobrenome: " + mk1.getSobrenome() );
        System.out.println("CPF: " + mk1.getCpf() );
        System.out.println("Endereço " + mk1.getEndereco() );
        System.out.println("Area " + mk1.getArea() );

        System.out.println("RECURSOS HUMANOS");
        RecursosHumanos rh1 = new RecursosHumanos(1,"fulano rh","da silva", "90520320", e1, 321123321 );

        System.out.println("ID: " + rh1.getId() );
        System.out.println("Nome: " + rh1.getNome() );
        System.out.println("Sobrenome: " + rh1.getSobrenome() );
        System.out.println("CPF: " + rh1.getCpf() );
        System.out.println("Endereço " + rh1.getEndereco() );
        System.out.println("Area " + rh1.getMetaAlcancada() );

        System.out.println("PRODUÇÂO: ");

        Producao p1 = new Producao(1,"fulano producao","da silva", "90520320", e1, 3 );

        System.out.println("ID: " + p1.getId() );
        System.out.println("Nome: " + p1.getNome() );
        System.out.println("Sobrenome: " + p1.getSobrenome() );
        System.out.println("CPF: " + p1.getCpf() );
        System.out.println("Endereço " + p1.getEndereco() );
        System.out.println("Area " + p1.getTempoExperiencia() );




    }
}