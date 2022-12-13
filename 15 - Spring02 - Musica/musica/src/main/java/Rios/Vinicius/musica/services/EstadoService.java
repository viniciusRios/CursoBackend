package Rios.Vinicius.musica.services;

import Rios.Vinicius.musica.dtos.EstadoDto;
import Rios.Vinicius.musica.entities.Estado;
import Rios.Vinicius.musica.repositories.EstadoRepository;
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
public class EstadoService {


    @Autowired// Injeção de dependencias
    private EstadoRepository repository;

    //Listar todos os estado e converte pra DTO
    @Transactional(readOnly = true)
    public List<EstadoDto> procurarTodos() {
        List<Estado> list = repository.findAll();
        return list.stream().map(x -> new EstadoDto(x)).collect(Collectors.toList());
    }

    //listar um Estado por ID

    @Transactional(readOnly = true)
    public EstadoDto proucurarPorId(Long id) {
        Optional<Estado> objeto = repository.findById(id); //Optional serve para tratar erros
        Estado entidade = objeto.orElseThrow(() -> new RecursoNaoEncontrado("Este ID não existe no sistema"));
        return new EstadoDto(entidade);
    }

    //Cadastrar um Estado
    @Transactional
    public EstadoDto inserir(EstadoDto dto) {
        Estado entidade = new Estado(); //null null
        entidade.setNome(dto.getNome()); // o id já é gerado direto lá no objeto
        entidade = repository.save(entidade);

        return new EstadoDto(entidade);
    }


    //Atualizar um Estado
    @Transactional
    public EstadoDto atualizar(Long id, EstadoDto dto) {
        try {
            Estado entidade = repository.getReferenceById(id);
            entidade.setNome(dto.getNome());
            entidade = repository.save(entidade);
            return new EstadoDto(entidade);

        }
        catch (EntityNotFoundException e){
            throw new RecursoNaoEncontrado("Id não existe, impossivel atualizar: " + id);
        }
    }


    //Deletar um Estado

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
