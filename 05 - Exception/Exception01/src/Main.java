import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num1, num2, div;


        try {
            System.out.println("Digite o numero 01: ");
            num1 = sc.nextInt();
            System.out.println("Digite o numero 02: ");
            num2 = sc.nextInt();

            div = num1 / num2;
            System.out.println("Resultado: " + div);
        }
        catch(ArithmeticException e1){
            System.err.println("Erro na divisão. Não pode dividir por ZERO");
        }
        catch(InputMismatchException e2){
            System.err.println("Erro na entrada de dados: ");
        }
        finally { // facultativo, vai rodar independente
            System.out.println("Fim do bloco de erro");
            sc.close();
        }


    }
}