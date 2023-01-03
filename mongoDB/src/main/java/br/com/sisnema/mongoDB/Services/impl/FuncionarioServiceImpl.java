package br.com.sisnema.mongoDB.Services.impl;

import br.com.sisnema.mongoDB.Services.FuncionarioService;
import br.com.sisnema.mongoDB.Services.SetorService;
import br.com.sisnema.mongoDB.entities.Funcionario;
import br.com.sisnema.mongoDB.entities.Setor;
import br.com.sisnema.mongoDB.repositories.FuncionarioRepository;
import br.com.sisnema.mongoDB.repositories.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

    @Autowired
    private FuncionarioRepository repository;

    @Override
    public Funcionario criar(Funcionario funcionario) {
        return this.repository.save(funcionario);
    }

    @Override
    public List<Funcionario> obterTodos() {
        return this.repository.findAll();
    }

    @Override
    public Funcionario obterPorCodigo(String codigo) {
        return this.repository.findById(codigo).orElseThrow(()-> new IllegalArgumentException("Setor Nulo ou Inexistente"));
    }

}
