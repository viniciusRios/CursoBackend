package Rios.Vinicius.musica.services;

import Rios.Vinicius.musica.dtos.PaisDto;
import Rios.Vinicius.musica.entities.Pais;
import Rios.Vinicius.musica.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaisService  {


    @Autowired// Injeção de dependencias
    private PaisRepository repository;

    //Listar todos os paises e converte pra DTO
    @Transactional(readOnly = true)
    public List<PaisDto> findAll(){

        List<Pais> list = repository.findAll(); //findAll é um SELECT * FROM TABELA_PAIS

        return list.stream().map(x -> new PaisDto(x)).collect(Collectors.toList()); // pega a lista, converte em novo DTO, coleta e coleta do coletor para outra lista já DTO
    }

    //listar um pais por ID

    @Transactional(readOnly = true)
    public PaisDto proucurarPorId(Long id){
        Optional<Pais> objeto = repository.findById(id); //Optional serve para tratar erros
        Pais entidade = objeto.get();
        return new PaisDto(entidade);
    }


    @Transactional
    public PaisDto inserir(PaisDto dto){
        Pais entidade = new Pais();
        entidade.setNome(dto.getNome()); // o id já é gerado direto lá no objeto
        entidade = repository.save(entidade);

        return new PaisDto(entidade);
    }
    //Cadastrar um pais



    //Atualizar um pais

    //Deletar um pais


}
