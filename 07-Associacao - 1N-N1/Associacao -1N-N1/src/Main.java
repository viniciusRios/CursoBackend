import entities.Pessoa;
import entities.Pet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        Pessoa p1 = new Pessoa(1,"Pedro");
        Pessoa p2 = new Pessoa(2,"Paula");
        Pessoa p3 = new Pessoa(3,"Moises");

        Pet pet1 = new Pet(1, "Fila", p1);
        Pet pet2 = new Pet(2, "Chiuaua", p2);
        Pet pet3 = new Pet(3, "bulldog", p3);
        Pet pet4 = new Pet(3, "basset", p3);


        System.out.println(pet1.toString());
        System.out.println(pet2.toString());
        System.out.println(pet3.toString());
    }
}