import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);


//        1.1.1 Construa um algoritmo que receba 1 (um) número inteiro e informe se ele é parou ímpar no console
//         int getNumero;
//        System.out.println("Informe o numero desejado: ");
//        getNumero = leitura.nextInt();
//
//        if (getNumero % 2 == 0){
//            System.out.println("O numero: "+getNumero+" é par");
//        }else {
//            System.out.println("O numero: "+getNumero+" é IMPAR");
//        }

//1.1.2 Construa um algoritmo que receba 3 (três) números inteiros e informe qual é omaior número.
//        int getNumero1, getNumero2, getNumero3;
//
//        System.out.println("Digite o numero 1");
//        getNumero1 = leitura.nextInt();
//        System.out.println("Digite o numero 2");
//        getNumero2 = leitura.nextInt();
//        System.out.println("Digite o numero 3");
//        getNumero3 = leitura.nextInt();
//
//        if(getNumero1 > getNumero2 && getNumero1 > getNumero3){
//            System.out.println("O primeiro numero é o maior: " + getNumero1);
//        } else if (getNumero2 > getNumero1 && getNumero2 > getNumero3) {
//            System.out.println("O segundo numero é maior: " + getNumero2);
//        } else  {
//            System.out.println("O terceito numero é maior: " + getNumero3);
//        }


//1.1.3 Construa um algoritmo que receba 6 (seis) notas, do tipo double, entre o
//  intervalo de 0.0 – 10.0 e logo após calcule a média aritmética. Ao final o
//  programa deve imprimir na tela o status do aluno com base nas seguintes
//  regras de avaliação:
//   0.0 – 2.99 Aluno reprovado por nota;
//   3.0 – 5.99 Aluno em recuperação;
//   6.0 – 10.0 Aluno aprovado por nota?
//        Double g1, g2, g3, g4, g5, g6, media;
//
//          System.out.println("Digite o numero 1");
//          g1 = leitura.nextDouble();
//          System.out.println("Digite o numero 2");
//          g2 = leitura.nextDouble();
//          System.out.println("Digite o numero 3");
//          g3 = leitura.nextDouble();
//          System.out.println("Digite o numero 4");
//          g4 = leitura.nextDouble();
//          System.out.println("Digite o numero 5");
//          g5 = leitura.nextDouble();
//          System.out.println("Digite o numero 6");
//          g6 = leitura.nextDouble();
//
//          media = (g1+g2+g3+g4+g5+g6) / 6;
//          System.out.printf("média do aluno %.2f :  ", media );
//
//          if(media < 3.0){
//              System.out.println("Aluno reprovado por nota ");
//          } else if (media >= 6.0) {
//              System.out.println("Aluno aprovado por nota ");
//          } else {
//              System.out.println("Aluno em recuperação");
//          }

//  1.2.1 Construa um algoritmo que receba um número inteiro no intervalo de 1 – 7 e
// imprima na tela o respectivo dia da semana na seguindo a tabela abaixo:
// 1 – domingo
// 2 – segunda-feira
// 3 – terça-feira
// 4 – quarta-feira
// 5 – quinta-feira
// 6 – sexta-feira
// 7 – sábado
// Caso seja digitado um valor fora do intervalo informar a mensagem: “Número
//inválido”.

//            int num;
//
//        System.out.println("Digite o dia respectivo ao dia da semana");
//        num = leitura.nextInt();
//
//        switch (num){
//            case 1:
//                System.out.println("Hoje é domingo");
//                break;
//            case 2:
//                System.out.println("Hoje é segunda");
//                break;
//            case 3:
//                System.out.println("Hoje é terça");
//                break;
//            case 4:
//                System.out.println("Hoje é quarta");
//                break;
//            case 5:
//                System.out.println("Hoje é quinta");
//                break;
//            case 6:
//                System.out.println("Hoje é sexta");
//                break;
//            case 7:
//                System.out.println("Hoje é sabado");
//                break;
//            default:
//                System.out.println("Numero invalido");
//                break;
//        }


//        1.3 Estruturas de repetição: WHILE
//        1.3.1 Construa um algoritmo que conte de zero até 50 e imprima somente os números
//        ímpares.
//
//        int numero = 0;
//
//        while (numero < 51) {
//            if(numero % 2 != 0){ //se for impar
//                System.out.println(numero);
//            }
//            numero++;
//        }

//       / 1.4 Estruturas de repetição: FOR
//        1.4.1 Construa um algoritmo que leia os salários de 15 funcionários e ao fim mostre a
//        média salarial dos mesmos.

         /*   double salario, mediaSalarial, acumulador=0.0;

            for(int i = 1; i <= 5; i++ ){
                System.out.println("Digite o " + i + "º salário: ");
                salario = leitura.nextDouble();
                acumulador += salario; //acumulador = acumulador + salario
            }

            mediaSalarial = acumulador / 5;
            System.out.printf("A media de funcionarios é de: " + mediaSalarial);



        System.out.println("Fim do programa");
        leitura.close();

          */


        /* 1.7.1 Construa um algoritmo que possua um array de 5 (cinco posições). Logo após
adicione as seguintes marcas: {“Ford”, “Chevrolet”, “Volkswagen”, “Fiat”, “Renault”}.
Depois busque dentro do vetor todas as palavras (pelas suas posições) e conte
quantas letras tem cada uma delas. Ao final imprima na tela qual delas possui a maior
quantidade de letras e quantas elas são.  ARRAYS */

            String[] marcas = new String[5];
            marcas[0] = "Ford";
            marcas[1] = "Chevrolet";
            marcas[2] = "VolksWagen";
            marcas[3] = "Fiat";
            marcas[4] = "Renaut";
            int maior=0 , indice=0;
            for(int i = 0; i <= 4; i++){

                int qtDeLetras = marcas[i].length();
                System.out.println(qtDeLetras);

                if(qtDeLetras > maior){
                    maior = qtDeLetras;
                    indice = i;
                }

            }

        System.out.println("Marca com maior qtd letras:  " + marcas[indice] + " Ela possui: " + maior +  "letras");


            leitura.close();






   //     Double salario; // Escopo global
     //   System.out.println("Informe o salario: ");
//
  //      salario = leitura.nextDouble();


    }

    public static void calculaImposto(Double sal){// publico - static - não retorna resultado - nome da classe - (tipo e recebido)

    }

}