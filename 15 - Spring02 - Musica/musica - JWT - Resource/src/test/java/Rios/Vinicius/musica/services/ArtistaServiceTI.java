package Rios.Vinicius.musica.services;

import Rios.Vinicius.musica.dtos.ArtistaDto;
import Rios.Vinicius.musica.repositories.ArtistaRepository;
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
public class ArtistaServiceTI {

    @Autowired
    private ArtistaService service;

    @Autowired
    private ArtistaRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long idChaveEstrangeira;
    private Long contagemTotalDeArtistas;
    private ArtistaDto artistaDto;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 4L;
        idNaoExistente = 999L;
        idChaveEstrangeira = 1L;
        contagemTotalDeArtistas = 4L;
        artistaDto = FactoryFK.criarArtistaDto();
    }

    @Test
    public void procurarTodosDeveriaRetornarUmaListaDeDtos() {
        List<ArtistaDto> lista = service.procurarTodos();
        Assertions.assertFalse(lista.isEmpty());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmDtoQuandoOIdExistir() {
        ArtistaDto resultado = service.procurarPorId(idExistente);
        Assertions.assertNotNull(resultado);
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmaExcecaoQuandoOIdNaoExistir() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.procurarPorId(idNaoExistente);
        });
    }

    @Test
    public void inserirDeveriaGravarUmObjetoNoBancoDeDados() {
        ArtistaDto resultado = service.inserir(artistaDto); // Retorna - 6L Uruguai
        Assertions.assertEquals(contagemTotalDeArtistas + 1, repository.count());
//        System.out.println("Quantidade de registros em Artista: " + repository.count());
//        System.out.println("Registro inserido em Artista: " + resultado);
    }

    @Test
    public void atualizarDeveriaGravarNovamenteUmMesmoObjeto() {
        ArtistaDto resultado = service.atualizar(idExistente, artistaDto);
        Assertions.assertNotNull(resultado);
//        System.out.println("Registro inserido em Artista: " + resultado);
    }

    @Test
    public void atualizarDeveriaLancarUmaExcecaoDeIdNaoEncontrado() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
           service.atualizar(idNaoExistente, artistaDto);
        });
    }

    @Test
    public void excluirDeveriaEliminarUmRegistro() {
        service.excluir(idExistente);
        Assertions.assertEquals(contagemTotalDeArtistas - 1, repository.count());
    }

    @Test
    public void excluirDeveriaLancarUmaExcecaoDeIdNaoEncontrado() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.excluir(idNaoExistente);
        });
    }

//    @Test
//    public void excluirDeveriaLancarUmaExcecaoDeIntegridade() {
//        Assertions.assertThrows(IntegridadeBD.class, () -> {
//            service.excluir(idChaveEstrangeira);
//        });
//    }
}
