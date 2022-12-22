package Rios.Vinicius.musica.test;

import Rios.Vinicius.musica.entities.Cidade;
import Rios.Vinicius.musica.entities.Estado;
import Rios.Vinicius.musica.entities.Genero;
import Rios.Vinicius.musica.entities.Pais;

public class Factory {

    public static Cidade criarCidade(){
        Cidade cidade = new Cidade(1L, "curitiba");
        return cidade;
    }
    //criar CidadeDto

    public static Estado criarEstado(){
        Estado estado  = new Estado(1L, "Mato grosso do sul");
        return estado;
    }

    //criar PaisDto

    public static Pais criarPais(){
        Pais pais  = new Pais(1L, "Uruguay");
        return pais;
    }


    //Criar GeneroDto
    public static Genero criarGenero(){
        Genero genero = new Genero(1L, "Axé");
        return genero;
    }


}
