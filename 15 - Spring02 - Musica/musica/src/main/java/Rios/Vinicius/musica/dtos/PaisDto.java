package Rios.Vinicius.musica.dtos;

import Rios.Vinicius.musica.entities.Pais;

public class PaisDto {

    private Long id;
    private String nome;



    public PaisDto() {
    }

    public PaisDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public PaisDto(Pais entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
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
}
