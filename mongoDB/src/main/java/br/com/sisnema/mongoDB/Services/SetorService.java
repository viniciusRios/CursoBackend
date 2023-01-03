package br.com.sisnema.mongoDB.Services;

import br.com.sisnema.mongoDB.entities.Setor;

import java.util.List;

public interface SetorService {

    Setor criar(Setor setor);
    List<Setor> obterTodos();
    Setor obterPorCodigo(String codigo);

}
