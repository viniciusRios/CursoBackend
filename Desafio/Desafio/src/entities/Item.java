package entities;

import java.util.Objects;

public class Item {

    protected Integer codigo:
    protected String descricao
    protected Double valor:
    protected Integer quantidade:
    protected Boolean disponibilidade:

    public Item() {
    }

    public Item(Integer codigo, String descricao, Double valor, Integer quantidade, Boolean disponibilidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
        this.disponibilidade = disponibilidade;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    //Metodos customizados
    public abstract double calculaValorDescaonto();

    public boolean verificaDisponibilidade(Integer codigo){
        boolean disp = false;
        if (codigo == this.codigo){
             disp = this.disponibilidade;
        }
        return disp;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(codigo, item.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                ", disponibilidade=" + disponibilidade +
                '}';
    }
}
