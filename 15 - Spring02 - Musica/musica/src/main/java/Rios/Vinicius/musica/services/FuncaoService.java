package Rios.Vinicius.musica.services;

import Rios.Vinicius.musica.dtos.FuncaoDto;
import Rios.Vinicius.musica.entities.Funcao;
import Rios.Vinicius.musica.repositories.FuncaoRepository;
import Rios.Vinicius.musica.services.exceptions.IntegridadeBD;
import Rios.Vinicius.musica.services.exceptions.RecursoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncaoService {


    @Autowired// Injeção de dependencias
    private FuncaoRepository repository;

    //Listar todos os funcoes e converte pra DTO
    @Transactional(readOnly = true)
    public List<FuncaoDto> procurarTodos() {
        List<Funcao> list = repository.findAll();
        // Expressão Lambda ou Alta ordem
        return list.stream().map(x -> new FuncaoDto(x)).collect(Collectors.toList());
    } // Retorna uma lista de FuncaoDto para o Controller

    //listar um funcao por ID

    @Transactional(readOnly = true)
    public FuncaoDto procurarPorId(Long id) {
        Optional<Funcao> objeto = repository.findById(id); //Optional serve para tratar erros
        Funcao entidade = objeto.orElseThrow(() -> new RecursoNaoEncontrado("Este ID não existe no sistema"));
        return new FuncaoDto(entidade);
    }

    //Cadastrar um funcao
    @Transactional
    public FuncaoDto inserir(FuncaoDto dto) {
        Funcao entidade = new Funcao();
        entidade.setAutoridade(dto.getAutoridade());
        entidade = repository.save(entidade);

        return new FuncaoDto(entidade);
    }


    //Atualizar um funcao
    @Transactional
    public FuncaoDto atualizar(Long id, FuncaoDto dto) {
        try {
            Funcao entidade = repository.getReferenceById(id);
            entidade.setAutoridade(dto.getAutoridade());
            entidade = repository.save(entidade);
            return new FuncaoDto(entidade);

        }
        catch (EntityNotFoundException e){
            throw new RecursoNaoEncontrado("Id não existe, impossivel atualizar: " + id);
        }
    }


    //Deletar um funcao

    public void excluir(Long id) {

        try{
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new RecursoNaoEncontrado("Id não encontrado: " + id);
        }
        catch (DataIntegrityViolationException e){
            throw new IntegridadeBD("Violação de integridade do banco");
        }

    }

}
