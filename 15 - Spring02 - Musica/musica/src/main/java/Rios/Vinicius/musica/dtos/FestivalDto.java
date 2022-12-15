package Rios.Vinicius.musica.dtos;

import Rios.Vinicius.musica.entities.Artista;
import Rios.Vinicius.musica.entities.Estado;
import Rios.Vinicius.musica.entities.Festival;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class FestivalDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String dataEvento;
    private Set<ArtistaDto> artistas = new HashSet<>();


    public FestivalDto() {
    }

    public FestivalDto(Long id, String nome, String dataEvento) {
        this.id = id;
        this.nome = nome;
        this.dataEvento = dataEvento;
    }

    public FestivalDto(Festival entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.dataEvento = entidade.getDataEvento();
    }

    //Construtor que receba os Artistas no festival
    public FestivalDto(Festival entidade, Set<Artista> artistas){ //0 1 2
        this(entidade);
        artistas.forEach(art -> this.artistas.add(new ArtistaDto(art)));
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Set<ArtistaDto> getArtistas() {
        return artistas;
    }
}
