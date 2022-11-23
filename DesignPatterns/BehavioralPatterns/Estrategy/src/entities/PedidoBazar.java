package entities;

public class PedidoBazar extends Pedido{

    private String descricao;

    public PedidoBazar() {
    }

    public PedidoBazar(Double valor, String descricao) {
        super(valor);
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public Double calcFreteComum() {
        return getValor() * 0.03;
    }

    @Override
    public Double calcFreteExpresso() throws Exception {

        throw new Exception("Modalidade Indisponivel");
    }
}
