package entities;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.Objects;

public class Veiculo {

        private Integer id;
        private String marca;
        private String modelo;
        private LocalDate anoFabricacao;
        private String placa;
        private String cidade;
        private String estado;
        private String chassi;
        private Integer renava ;



        public Veiculo(){
    }

    public Veiculo(Integer id, String marca, String modelo, LocalDate anoFabricacao, String placa, String cidade, String estado, String chassi, Integer renava) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.placa = placa;
        this.cidade = cidade;
        this.estado = estado;
        this.chassi = chassi;
        this.renava = renava;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(LocalDate anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Integer getRenava() {
        return renava;
    }

    public void setRenava(Integer renava) {
        this.renava = renava;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(id, veiculo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anoFabricacao=" + anoFabricacao +
                ", placa='" + placa + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", chassi='" + chassi + '\'' +
                ", renava=" + renava +
                '}';
    }

}


