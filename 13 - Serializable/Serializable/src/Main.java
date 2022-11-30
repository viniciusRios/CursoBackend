import entities.Cachorro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        //serializable
        // transforma a info na memória em arquivo, pra enviar e tudo mais...

        List<Cachorro> cachorros = new ArrayList<>();

        Cachorro c1 = new Cachorro("Pluto1", "Fila", 10, "Rua do Pluto");
        Cachorro c2 = new Cachorro("tob1", "beagle", 5, "Rua do beagle");
        Cachorro c3 = new Cachorro("burpee1", "ruskie", 3, "Rua do burpee");

        cachorros.add(c1);
        cachorros.add(c2);
        cachorros.add(c3);

        //Salvar a colecao de cachorros em um arquivo: saida.TXT (FileoutputStream)
        FileOutputStream fo = null;

        try{
            fo = new FileOutputStream("Saida.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(cachorros);

        }
        catch (FileNotFoundException e){
            System.out.println("Error de FNFE" + e.getMessage());
        }
        catch (Exception e){
            System.out.println("Error de Exception" + e.getMessage());

        }

        // Recuperar a coleção de cachorros lá do TXT

        List<Cachorro> recuperaCachorros = null;
        FileInputStream fi = null;


        try{
            fi = new FileInputStream("Saida.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);
            recuperaCachorros = (ArrayList) ois.readObject();//Utilizar um Casting para trocar de Objeto para ArrayList


        }
        catch (FileNotFoundException e){
            System.out.println("Error de FNFE" + e.getMessage());
        }
        catch (Exception e){
            System.out.println("Error de Exception" + e.getMessage());
        }

        for(Cachorro cach : recuperaCachorros){
            System.out.println(
                    cach.getNome() + " | "+
                    cach.getRaca() + " | "+
                    cach.getIdade() + " | "+
                    cach.getEndereco()+  " | "
            );
        }

        }

}