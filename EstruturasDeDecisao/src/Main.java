import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        // Estruturas condicionais
           // Short idade = 10;
//
//        //IF Simples
//        if (idade >= 18){ // retorna true
//            System.out.println("Usuario Apto a realizar o Exame");
//
//        }

//        //IF Composto
//        if (idade >= 18){ // retorna true
//            System.out.println("Usuario Apto a realizar o Exame");
//
//        }else {
//            System.out.println("Usuario Inapto");
//        }
//




        // IF concatenado
        Locale.setDefault(Locale.US);


            Double salario = 0.0 ;
            Double getSalario = 0.0;
            Double dedDependente = 189.59;
            int qtd = 0;

            Scanner sc = new Scanner(System.in);//declara sc como tipo scanner
            //Ler salario
            System.out.println("Digite o salario do funcionario: ");
            getSalario = sc.nextDouble();


            //Ler se há dependentes e quantos são
            System.out.print("Digite a quantidade de dependentes: ");
            qtd = sc.nextInt();



            salario = getSalario - (qtd*dedDependente);
            System.out.println("Valor deduzido de dependentes: " + (qtd*dedDependente));
            System.out.println("Valor do salario deduzido: " + salario);

            //Calcular quanto o funcionario irá receber


        if (salario > 0.0 && salario <= 1903.98){
            System.out.println("Funcionario Isento de IR em 2022");

        } else if (salario >= 1903.99 && salario <= 2826.65) {
            System.out.println("Alicota de 7.5% a pagar");
            salario = salario - 142.80;
            salario = salario - (salario * 0.075);

        } else if (salario >= 2826.66 && salario <= 3751.05) {
            System.out.println("Alicota de 15% a pagar");
            salario = salario - 354.80;
            salario = salario - (salario * 0.15);


        } else if (salario >= 3751.06 && salario <= 4664.69) {
                System.out.println("Alicota de 22,5% a pagar");
                salario = salario - 636.13;
                salario = salario - (salario * 0.225);

        } else if (salario >= 4664.68 ) {
            System.out.println("Alicota de 7.5% a pagar");
            salario = salario - 142.88;
            salario = salario - (salario * 0.275);

        }
        System.out.println("O salario liquido é de: R$" + salario);
        System.out.println("Imposto a pagar: R$" + (getSalario - salario) );
        System.out.println("Fim do programa");

    }
}

