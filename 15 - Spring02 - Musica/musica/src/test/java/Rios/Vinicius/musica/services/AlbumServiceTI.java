package Rios.Vinicius.musica.services;

import Rios.Vinicius.musica.dtos.AlbumDto;
import Rios.Vinicius.musica.repositories.AlbumRepository;
import Rios.Vinicius.musica.services.exceptions.RecursoNaoEncontrado;
import Rios.Vinicius.musica.test.FactoryFK;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class AlbumServiceTI {

    @Autowired
    private AlbumService service;

    @Autowired
    private AlbumRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeAlbuns;
    
    private AlbumDto albumDto;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 6L;
        idNaoExistente = 999L;
        contagemTotalDeAlbuns = 39L;
        albumDto = FactoryFK.criarAlbumDto();
    }

    @Test
    public void procurarTodosDeveriaRtornarUmaListaDeDtos(){
        List<AlbumDto> lista = service.procurarTodos();
        Assertions.assertFalse(lista.isEmpty());
    }

    @Test
    public void procurarPorIdDeveriaRetornarQuandoOIdExistir(){
        AlbumDto resultado = service.procurarPorId(idExistente);
        Assertions.assertNotNull(resultado);
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmaExcecaoQuandoOIdNaoExistir(){

        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.procurarPorId(idNaoExistente);
        });
    }

    @Test
    public void inserirDeveriaGravarUmObjetoNoBancoDeDados(){
        AlbumDto resultado = service.inserir(albumDto); 
        Assertions.assertNotNull(resultado);
    }

    @Test
    public void atualizarDeveriaGravarNovamenteUmMesmoObjeto(){
        AlbumDto resultado = service.atualizar(idExistente, albumDto);
        Assertions.assertNotNull(resultado);

    }

    @Test
    public void atualizarDeveriaLancarUmaExcecaoQuandoORegistroNaoExistir(){
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.atualizar(idNaoExistente, albumDto);
        });
    }

    @Test
    public void excluirDeveriaEliminarUmObjetoOuUmRegistro(){
        service.excluir(idExistente);
        Assertions.assertEquals(contagemTotalDeAlbuns -1, repository.count());

    }

    @Test
    public void excluirDeveriaLancarUmaExcecaoDeIdNaoEncontrado(){
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.excluir(idNaoExistente);
        });
    }




}
