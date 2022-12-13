package Rios.Vinicius.musica.services;

import Rios.Vinicius.musica.dtos.GeneroDto;
import Rios.Vinicius.musica.entities.Genero;
import Rios.Vinicius.musica.repositories.GeneroRepository;
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
public class GeneroService {


    @Autowired// Injeção de dependencias
    private GeneroRepository repository;

    //Listar todos os Genero e converte pra DTO
    @Transactional(readOnly = true)
    public List<GeneroDto> procurarTodos() {
        List<Genero> list = repository.findAll();
        return list.stream().map(x -> new GeneroDto(x)).collect(Collectors.toList());
    }

    //listar um Genero por ID

    @Transactional(readOnly = true)
    public GeneroDto proucurarPorId(Long id) {
        Optional<Genero> objeto = repository.findById(id); //Optional serve para tratar erros
        Genero entidade = objeto.orElseThrow(() -> new RecursoNaoEncontrado("Este ID não existe no sistema"));
        return new GeneroDto(entidade);
    }

    //Cadastrar um Genero
    @Transactional
    public GeneroDto inserir(GeneroDto dto) {
        Genero entidade = new Genero(); //null null
        entidade.setNome(dto.getNome()); // o id já é gerado direto lá no objeto
        entidade = repository.save(entidade);

        return new GeneroDto(entidade);
    }


    //Atualizar um Genero
    @Transactional
    public GeneroDto atualizar(Long id, GeneroDto dto) {
        try {
            Genero entidade = repository.getReferenceById(id);
            entidade.setNome(dto.getNome());
            entidade = repository.save(entidade);
            return new GeneroDto(entidade);

        }
        catch (EntityNotFoundException e){
            throw new RecursoNaoEncontrado("Id não existe, impossivel atualizar: " + id);
        }
    }


    //Deletar um Genero

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
