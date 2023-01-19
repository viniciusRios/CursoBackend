package Rios.Vinicius.musica.services;

import Rios.Vinicius.musica.dtos.PaisDto;
import Rios.Vinicius.musica.repositories.PaisRepository;
import Rios.Vinicius.musica.services.exceptions.RecursoNaoEncontrado;
import Rios.Vinicius.musica.test.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class PaisServiceTI {

    @Autowired
    private PaisService service;

    @Autowired
    private PaisRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDePaises;

    private PaisDto paisDto;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 2L;
        idNaoExistente = 999L;
        contagemTotalDePaises = 5L;
        paisDto = Factory.criarPaisDto();
    }

    @Test
    public void procurarTodosDeveriaRtornarUmaListaDeDtos(){
        List<PaisDto> lista = service.procurarTodos();
        Assertions.assertFalse(lista.isEmpty());
    }

    @Test
    public void procurarPorIdDeveriaRetornarQuandoOIdExistir(){
        PaisDto resultado = service.procurarPorId(idExistente);
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
        PaisDto resultado = service.inserir(paisDto); //retorna - 6L uruguai
        Assertions.assertEquals(contagemTotalDePaises +1 ,repository.count());
    }

    @Test
    public void atualizarDeveriaGravarNovamenteUmMesmoObjeto(){
        PaisDto resultado = service.atualizar(idExistente, paisDto);
        Assertions.assertNotNull(resultado);

    }

    @Test
    public void atualizarDeveriaLancarUmaExcecaoQuandoORegistroNaoExistir(){
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.atualizar(idNaoExistente, paisDto);
        });
    }

    @Test
    public void excluirDeveriaEliminarUmObjetoOuUmRegistro(){
        service.excluir(idExistente);
        Assertions.assertEquals(contagemTotalDePaises -1, repository.count());

    }

    @Test
    public void excluirDeveriaLancarUmaExcecaoDeIdNaoEncontrado(){
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.excluir(idNaoExistente);
        });
    }




}
