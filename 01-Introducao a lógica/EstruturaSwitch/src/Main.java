import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Double valorCompra;
        int percDesconto ;

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o valor da compra: ");
        valorCompra = sc.nextDouble();
        System.out.println("Digite o percentual do desconto");
        percDesconto = sc.nextInt();

        switch (percDesconto){
            case 5:
                System.out.println("desconto de 5% concedido");
                break;

            case 15:
                System.out.println("desconto de 15% concedido");
                break;

            case 25:
                System.out.println("desconto de 25% concedido");
                break;

            default:
                System.out.println("Cliente sem desconto");
        }

        sc.close();
    }
}