package Rios.Vinicius.musica.dtos;

import Rios.Vinicius.musica.entities.Artista;
import Rios.Vinicius.musica.entities.Pais;

import java.io.Serializable;

public class ArtistaDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private boolean banda;
    private Long pais_id;
    private Long estado_id;
    private Long cidade_id;
    private Long genero_id;



    public ArtistaDto() {
    }

    public ArtistaDto(Long id, String nome, boolean banda, Long pais_id, Long estado_id, Long cidade_id, Long genero_id ) {
        this.id = id;
        this.nome = nome;
        this.banda = banda;
        this.pais_id = pais_id;
        this.estado_id = estado_id;
        this.cidade_id = cidade_id;
        this.genero_id = genero_id;
    }

    public ArtistaDto(Artista entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.banda = entidade.isBanda();
        this.pais_id = entidade.getPais().getId();
        this.estado_id = entidade.getEstado().getId();
        this.cidade_id = entidade.getCidade().getId();
        this.genero_id = entidade.getGenero().getId();
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

    public boolean isBanda() {
        return banda;
    }

    public void setBanda(boolean banda) {
        this.banda = banda;
    }

    public Long getPais_id() {
        return pais_id;
    }

    public void setPais_id(Long pais_id) {
        this.pais_id = pais_id;
    }

    public Long getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(Long estado_id) {
        this.estado_id = estado_id;
    }

    public Long getCidade_id() {
        return cidade_id;
    }

    public void setCidade_id(Long cidade_id) {
        this.cidade_id = cidade_id;
    }

    public Long getGenero_id() {
        return genero_id;
    }

    public void setGenero_id(Long genero_id) {
        this.genero_id = genero_id;
    }
}
