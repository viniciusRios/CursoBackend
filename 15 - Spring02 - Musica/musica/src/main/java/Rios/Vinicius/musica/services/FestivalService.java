package Rios.Vinicius.musica.services;

import Rios.Vinicius.musica.dtos.ArtistaDto;
import Rios.Vinicius.musica.dtos.FestivalDto;
import Rios.Vinicius.musica.entities.*;
import Rios.Vinicius.musica.repositories.ArtistaRepository;
import Rios.Vinicius.musica.repositories.FestivalRepository;
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
public class FestivalService {

    @Autowired
    private FestivalRepository repository;

    @Autowired
    private ArtistaRepository artistaRepository;

    @Transactional(readOnly = true) //Proucurar todos festivais
    public List<FestivalDto> proucurarTodos(){
        List<Festival> list = repository.findAll();
        return list.stream().map(x -> new FestivalDto(x, x.getArtistas())).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public FestivalDto procurarPorId(Long id) {
        Optional<Festival> objeto = repository.findById(id);
        Festival entidade = objeto.orElseThrow(() ->
                new RecursoNaoEncontrado("Este ID de festival não existe em nosso sistema.")
        );
        return new FestivalDto(entidade, entidade.getArtistas());
    }

    @Transactional
    public FestivalDto inserir (FestivalDto dto){
        Festival entidade = new Festival();
        copiarDTOParaEntidade(dto, entidade);
        entidade = repository.save(entidade);
        return new FestivalDto(entidade);
    }


    @Transactional
    public FestivalDto atualizar(Long id, FestivalDto dto) {
        try {
            Festival entidade = repository.getReferenceById(id);
            copiarDTOParaEntidade(dto, entidade);
            entidade = repository.save(entidade);
            return new FestivalDto(entidade);
        }
        catch (EntityNotFoundException e) {
            throw new RecursoNaoEncontrado("Id não encontrado: " + id);
        }
    }

        public void excluir(Long id){
            try {
                repository.deleteById(id);
            }
            catch (EmptyResultDataAccessException e) {
                throw new RecursoNaoEncontrado("Id não encontrado: " + id);
            }
            catch (DataIntegrityViolationException e) {
                throw new IntegridadeBD("Violação de integridade no banco de dados.");
            }
        }

    private void copiarDTOParaEntidade(FestivalDto dto, Festival entidade){
        entidade.setNome(dto.getNome());
        entidade.setDataEvento(dto.getDataEvento());

        entidade.getArtistas().clear();
        for(ArtistaDto artDto : dto.getArtistas()){
            Artista artista = artistaRepository.getReferenceById(artDto.getId());
            entidade.getArtistas().add(artista);
        }

    }


}
