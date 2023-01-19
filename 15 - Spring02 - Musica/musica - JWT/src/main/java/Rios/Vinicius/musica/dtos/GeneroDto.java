package Rios.Vinicius.musica.dtos;

import Rios.Vinicius.musica.entities.Genero;
import Rios.Vinicius.musica.entities.Pais;

import java.io.Serializable;

public class GeneroDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;



    public GeneroDto() {
    }

    public GeneroDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public GeneroDto(Genero entidade) {
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
