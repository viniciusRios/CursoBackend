package Rios.Vinicius.musica.dtos;

import Rios.Vinicius.musica.entities.Estado;
import Rios.Vinicius.musica.entities.Festival;

import java.io.Serializable;
import java.time.Instant;

public class FestivalDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private Instant dataEvento;



    public FestivalDto() {
    }

    public FestivalDto(Long id, String nome, Instant dataEvento) {
        this.id = id;
        this.nome = nome;
        this.dataEvento = dataEvento;
    }

    public FestivalDto(Festival entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.dataEvento = entidade.getDataEvento();
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

    public Instant getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Instant dataEvento) {
        this.dataEvento = dataEvento;
    }

}
