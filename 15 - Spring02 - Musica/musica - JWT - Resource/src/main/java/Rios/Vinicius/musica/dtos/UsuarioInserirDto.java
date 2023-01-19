package Rios.Vinicius.musica.dtos;

public class UsuarioInserirDto extends UsuarioDto {

    private String senha;

    public UsuarioInserirDto() {
        super();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
