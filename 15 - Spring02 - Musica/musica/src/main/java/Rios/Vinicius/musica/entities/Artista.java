package Rios.Vinicius.musica.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



@Entity // cria uma tabela pelo Spring
@Table(name = "tabela_artista") // Renomeia a tabela para tabela_artista
public class Artista implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // campo definido como chave primaria
    @GeneratedValue(strategy =  GenerationType.IDENTITY) // gera o valor (pacote strategy que gera a identificação automatico - AutoIncremento)
    private Long id;
    private String nome;
    private boolean banda;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

   @OneToMany(mappedBy = "artista")
   private List<Album> albuns = new ArrayList<>();


    public Artista() {
    }

    public Artista(Long id) {
        this.id = id;
    }

    public Artista(Long id, String nome, boolean banda, Pais pais, Estado estado, Cidade cidade) {
        this.id = id;
        this.nome = nome;
        this.banda = banda;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
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

    public List<Album> getAlbuns() {
        return albuns;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artista artista = (Artista) o;
        return Objects.equals(id, artista.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Artista{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", banda=" + banda +
                ", pais=" + pais +
                ", estado=" + estado +
                ", cidade=" + cidade +
                ", albuns=" + albuns +
                '}';
    }
}
