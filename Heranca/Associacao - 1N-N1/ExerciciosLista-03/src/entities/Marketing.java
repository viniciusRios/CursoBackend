package entities;

public class Marketing extends Funcionario {

    private String area;

    public Marketing() {
    }

    public Marketing(int id, String nome, String sobrenome, String cpf, Endereco endereco, String area) {
        super(id, nome, sobrenome, cpf, endereco);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    //Metodos customizados
    public void trabalhar(){

    }

    @Override
    public String toString() {
        return super.toString() +
                "Marketing{" +
                "area='" + area + '\'' +
                '}';
    }
}
