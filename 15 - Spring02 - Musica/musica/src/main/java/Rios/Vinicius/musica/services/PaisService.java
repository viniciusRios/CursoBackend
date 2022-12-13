package Rios.Vinicius.musica.services;

import Rios.Vinicius.musica.dtos.PaisDto;
import Rios.Vinicius.musica.entities.Pais;
import Rios.Vinicius.musica.repositories.PaisRepository;
import Rios.Vinicius.musica.services.exceptions.IntegridadeBD;
import Rios.Vinicius.musica.services.exceptions.RecursoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaisService {


    @Autowired// Injeção de dependencias
    private PaisRepository repository;

    //Listar todos os paises e converte pra DTO
    @Transactional(readOnly = true)
    public List<PaisDto> procurarTodos() {
        List<Pais> list = repository.findAll();
        // Expressão Lambda ou Alta ordem
        return list.stream().map(x -> new PaisDto(x)).collect(Collectors.toList());
    } // Retorna uma lista de PaisDto para o Controller

    //listar um pais por ID

    @Transactional(readOnly = true)
    public PaisDto proucurarPorId(Long id) {
        Optional<Pais> objeto = repository.findById(id); //Optional serve para tratar erros
        Pais entidade = objeto.orElseThrow(() -> new RecursoNaoEncontrado("Este ID não existe no sistema"));
        return new PaisDto(entidade);
    }

    //Cadastrar um pais
    @Transactional
    public PaisDto inserir(PaisDto dto) {
        Pais entidade = new Pais(); //null null
        entidade.setNome(dto.getNome()); // o id já é gerado direto lá no objeto
        entidade = repository.save(entidade);

        return new PaisDto(entidade);
    }


    //Atualizar um pais
    @Transactional
    public PaisDto atualizar(Long id, PaisDto dto) {
        try {
            Pais entidade = repository.getReferenceById(id); //6
            entidade.setNome(dto.getNome()); // russia
            entidade = repository.save(entidade);
            return new PaisDto(entidade);

        }
        catch (EntityNotFoundException e){
            throw new RecursoNaoEncontrado("Id não existe, impossivel atualizar: " + id);
        }
    }


    //Deletar um pais

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
