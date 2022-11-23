import java.util.*;

public class Main {
    public static void main(String[] args) {

        List ourList = new ArrayList<>();

        ourList.add("Primeiro add");
        ourList.add("segundo add");
        ourList.add("terceiro add");
        ourList.add("quarto add");
        ourList.add("quinto add");
        ourList.add("sexto add");


        System.out.println("Tamanho da lista " + ourList.size());

        System.out.println("Show List com For " + ourList);

        for (int i = 0; i < ourList.size(); i++){
            System.err.println(ourList.get(i));
        }

        Set ourSet = new HashSet();
        ourSet.add("");

    }

    HashMap (1,);
}