package Rios.Vinicius.musica.services;

import Rios.Vinicius.musica.dtos.EstadoDto;
import Rios.Vinicius.musica.repositories.EstadoRepository;
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
public class EstadoServiceTI {

    @Autowired
    private EstadoService service;

    @Autowired
    private EstadoRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeEstados;
    
    private EstadoDto estadoDto;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 3L;
        idNaoExistente = 999L;
        contagemTotalDeEstados = 6L;
        estadoDto = Factory.criarEstadoDto();
    }

    @Test
    public void procurarTodosDeveriaRtornarUmaListaDeDtos(){
        List<EstadoDto> lista = service.procurarTodos();
        Assertions.assertFalse(lista.isEmpty());
    }

    @Test
    public void procurarPorIdDeveriaRetornarQuandoOIdExistir(){
        EstadoDto resultado = service.procurarPorId(idExistente);
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
        EstadoDto resultado = service.inserir(estadoDto);
        Assertions.assertEquals(contagemTotalDeEstados +1 ,repository.count());
    }

    @Test
    public void atualizarDeveriaGravarNovamenteUmMesmoObjeto(){
        EstadoDto resultado = service.atualizar(idExistente, estadoDto);
        Assertions.assertNotNull(resultado);

    }

    @Test
    public void atualizarDeveriaLancarUmaExcecaoQuandoORegistroNaoExistir(){
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.atualizar(idNaoExistente, estadoDto);
        });
    }

    @Test
    public void excluirDeveriaEliminarUmObjetoOuUmRegistro(){
        service.excluir(idExistente);
        Assertions.assertEquals(contagemTotalDeEstados -1, repository.count());

    }

    @Test
    public void excluirDeveriaLancarUmaExcecaoDeIdNaoEncontrado(){
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.excluir(idNaoExistente);
        });
    }




}
