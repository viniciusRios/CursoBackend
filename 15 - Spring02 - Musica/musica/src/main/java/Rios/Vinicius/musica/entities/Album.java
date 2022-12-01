package Rios.Vinicius.musica.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity // cria uma tabela pelo Spring
@Table(name = "tabela_album") // Renomeia a tabela
public class Album {

    @Id // campo definido como chave primaria
    @GeneratedValue(strategy =  GenerationType.IDENTITY) // gera o valor (pacote strategy que gera a identificação automatico - AutoIncremento)
    private Long id;
    private String titulo;
    private Integer ano;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    public Album() {
    }

    public Album(Long id, String titulo, Integer ano) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
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
