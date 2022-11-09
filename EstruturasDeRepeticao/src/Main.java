
public class Main {
    public static void main(String[] args) {


        Integer valor = 0;
//
//        while (valor < 10){ // enquanto for TRUE
//            valor++; // add 1 no valor (Incrementa)
//            System.out.println(valor);
//
//        }
            //Para  // Inicialização;Condição;Incre-Decremento
//        for (int i = 0; i >= valor; i++){
//            System.out.println(i);
//        }
//
        // Declaração de Array
        double[] notas = {6.5, 9.4, 9.8, 6.3, 7.4 }; //[0,1,2,3,4]


        for (Double item : notas) {
            System.out.println(item);
        }

        System.out.println("Fim do programa");

    }
}