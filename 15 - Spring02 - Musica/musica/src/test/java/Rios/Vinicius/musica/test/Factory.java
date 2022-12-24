package Rios.Vinicius.musica.test;

import Rios.Vinicius.musica.dtos.CidadeDto;
import Rios.Vinicius.musica.dtos.EstadoDto;
import Rios.Vinicius.musica.dtos.GeneroDto;
import Rios.Vinicius.musica.dtos.PaisDto;
import Rios.Vinicius.musica.entities.Cidade;
import Rios.Vinicius.musica.entities.Estado;
import Rios.Vinicius.musica.entities.Genero;
import Rios.Vinicius.musica.entities.Pais;

public class Factory {


    public static Cidade criarCidade(){
        Cidade cidade = new Cidade(1L, "curitiba");
        return cidade;
    }
    public static CidadeDto criarCidadeDto(){
        Cidade cidade = criarCidade();
        return new CidadeDto(cidade);
    }


    public static Estado criarEstado(){
        Estado estado  = new Estado(1L, "Mato grosso do sul");
        return estado;
    }

    public static EstadoDto criarEstadoDto(){
        Estado estado = criarEstado();
        return new EstadoDto(estado);
    }


    public static Pais criarPais(){
        Pais pais  = new Pais(1L, "Uruguay");
        return pais;
    }
    public static PaisDto criarPaisDto(){
        Pais pais = criarPais();
        return new PaisDto(pais);
    }


    //Criar GeneroDto
    public static Genero criarGenero(){
        Genero genero = new Genero(1L, "Axé");
        return genero;
    }
    public static GeneroDto criarGeneroDto(){
        Genero genero = criarGenero();
        return new GeneroDto(genero);
    }



}
