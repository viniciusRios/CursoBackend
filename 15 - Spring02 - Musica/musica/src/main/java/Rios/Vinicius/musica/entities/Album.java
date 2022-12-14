package Rios.Vinicius.musica.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity // cria uma tabela pelo Spring
@Table(name = "tabela_album") // Renomeia a tabela
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id // campo definido como chave primaria
    @GeneratedValue(strategy =  GenerationType.IDENTITY) // gera o valor (pacote strategy que gera a identificação automatico - AutoIncremento)
    private Long id;
    private String titulo;
    private Integer ano;


    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;


    public Album() {
    }

    public Album(Long id, String titulo, Integer ano, Artista artista, Genero genero) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.artista = artista;
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAno() {
        return ano;
    }


    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", ano=" + ano +
                '}';
    }
}
