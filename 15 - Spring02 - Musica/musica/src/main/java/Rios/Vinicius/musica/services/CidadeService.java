package Rios.Vinicius.musica.services;

import Rios.Vinicius.musica.dtos.CidadeDto;
import Rios.Vinicius.musica.entities.Cidade;
import Rios.Vinicius.musica.repositories.CidadeRepository;
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
public class CidadeService {


    @Autowired// Injeção de dependencias
    private CidadeRepository repository;

    //Listar todos os Cidade e converte pra DTO
    @Transactional(readOnly = true)
    public List<CidadeDto> findAll() {

        List<Cidade> list = repository.findAll(); //findAll é um SELECT * FROM TABELA_Cidade

        return list.stream().map(x -> new CidadeDto(x)).collect(Collectors.toList()); // pega a lista, converte em novo DTO, coleta e coleta do coletor para outra lista já DTO
    }

    //listar um Cidade por ID

    @Transactional(readOnly = true)
    public CidadeDto proucurarPorId(Long id) {
        Optional<Cidade> objeto = repository.findById(id); //Optional serve para tratar erros
        Cidade entidade = objeto.orElseThrow(() -> new RecursoNaoEncontrado("Este ID não existe no sistema"));
        return new CidadeDto(entidade);
    }

    //Cadastrar um Cidade
    @Transactional
    public CidadeDto inserir(CidadeDto dto) {
        Cidade entidade = new Cidade(); //null null
        entidade.setNome(dto.getNome()); // o id já é gerado direto lá no objeto
        entidade = repository.save(entidade);

        return new CidadeDto(entidade);
    }


    //Atualizar um Cidade
    @Transactional
    public CidadeDto atualizar(Long id, CidadeDto dto) {
        try {
            Cidade entidade = repository.getReferenceById(id);
            entidade.setNome(dto.getNome());
            entidade = repository.save(entidade);
            return new CidadeDto(entidade);

        }
        catch (EntityNotFoundException e){
            throw new RecursoNaoEncontrado("Id não existe, impossivel atualizar: " + id);
        }
    }


    //Deletar um Cidade

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
