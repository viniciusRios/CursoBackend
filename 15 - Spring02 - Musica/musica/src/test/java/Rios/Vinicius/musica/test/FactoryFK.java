package Rios.Vinicius.musica.test;

import Rios.Vinicius.musica.dtos.AlbumDto;
import Rios.Vinicius.musica.dtos.ArtistaDto;
import Rios.Vinicius.musica.dtos.FestivalDto;
import Rios.Vinicius.musica.entities.Album;
import Rios.Vinicius.musica.entities.Artista;
import Rios.Vinicius.musica.entities.Festival;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;

import static Rios.Vinicius.musica.test.Factory.*;

public class FactoryFK {


    //Artista
    public static Artista criarArtista(){
        Artista artista = new Artista(1L, "Molotov", true, criarPais(),criarEstado(), criarCidade(), criarGenero() );
        return artista;
    }
    public static ArtistaDto criarArtistaDto(){
        Artista artista = criarArtista();
        return new ArtistaDto(artista);
    }
    //Album
    public static Album criarAlbum(){
        Album album = new Album(1L,"S&M",2000, criarArtista(), criarGenero()  );
        return album;
    }
    public static AlbumDto criarAlbumDto(){
        Album album = criarAlbum();
        return new AlbumDto(album);
    }

    //Festival
    public static Festival criarFestival(){
        Festival festival = new Festival(1L, "Atlantida", Instant.now());
        return festival;
    }
    public static FestivalDto criaFestivalDto(){
        Festival festival = criarFestival();
        return new FestivalDto(festival);
    }

}
