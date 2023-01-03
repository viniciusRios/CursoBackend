package br.com.sisnema.mongoDB.Services.impl;

import br.com.sisnema.mongoDB.Services.SetorService;
import br.com.sisnema.mongoDB.entities.Setor;
import br.com.sisnema.mongoDB.repositories.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetorServiceImpl implements SetorService {


    @Autowired
    private SetorRepository repository;

    @Override
    public Setor criar(Setor setor) {
        return this.repository.save(setor);
    }

    @Override
    public List<Setor> obterTodos() {
        return this.repository.findAll();
    }

    @Override
    public Setor obterPorCodigo(String codigo) {
        return this.repository.findById(codigo).orElseThrow(()-> new IllegalArgumentException("Setor Nulo ou Inexistente"));
    }

}
