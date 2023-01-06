package Rios.Vinicius.musica.services;

import Rios.Vinicius.musica.dtos.CidadeDto;
import Rios.Vinicius.musica.repositories.CidadeRepository;
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
public class CidadeServiceTI {

    @Autowired
    private CidadeService service;

    @Autowired
    private CidadeRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeCidades;
    
    private CidadeDto cidadeDto;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 5L;
        idNaoExistente = 999L;
        contagemTotalDeCidades = 6L;
        cidadeDto = Factory.criarCidadeDto();
    }

    @Test
    public void procurarTodosDeveriaRtornarUmaListaDeDtos(){
        List<CidadeDto> lista = service.procurarTodos();
        Assertions.assertFalse(lista.isEmpty());
    }

    @Test
    public void procurarPorIdDeveriaRetornarQuandoOIdExistir(){
        CidadeDto resultado = service.procurarPorId(idExistente);
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
        CidadeDto resultado = service.inserir(cidadeDto); 
        Assertions.assertEquals(contagemTotalDeCidades +1 ,repository.count());
    }

    @Test
    public void atualizarDeveriaGravarNovamenteUmMesmoObjeto(){
        CidadeDto resultado = service.atualizar(idExistente, cidadeDto);
        Assertions.assertNotNull(resultado);

    }

    @Test
    public void atualizarDeveriaLancarUmaExcecaoQuandoORegistroNaoExistir(){
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.atualizar(idNaoExistente, cidadeDto);
        });
    }

    @Test
    public void excluirDeveriaEliminarUmObjetoOuUmRegistro(){
        service.excluir(idExistente);
        Assertions.assertEquals(contagemTotalDeCidades -1, repository.count());

    }

    @Test
    public void excluirDeveriaLancarUmaExcecaoDeIdNaoEncontrado(){
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.excluir(idNaoExistente);
        });
    }




}
