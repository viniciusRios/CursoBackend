package Rios.Vinicius.musica.services;

import Rios.Vinicius.musica.dtos.GeneroDto;
import Rios.Vinicius.musica.entities.Genero;
import Rios.Vinicius.musica.repositories.GeneroRepository;
import Rios.Vinicius.musica.services.exceptions.IntegridadeBD;
import Rios.Vinicius.musica.services.exceptions.RecursoNaoEncontrado;
import Rios.Vinicius.musica.test.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
public class GeneroServiceTest {

    @InjectMocks
    private GeneroService service;

    @Mock
    private GeneroRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeGeneroes;
    private Long idChaveEstrangeira;
    private List<Genero> generoList = new ArrayList<>();
    private Genero genero;
    private GeneroDto generoDto;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 999L;
        idChaveEstrangeira = 2L;
        contagemTotalDeGeneroes = 9L;
        genero = Factory.criarGenero();
        generoDto = Factory.criarGeneroDto();
        generoList = new ArrayList<>();

        // Simulações da camada de repository;
        Mockito.when(repository.findAll()).thenReturn(generoList);

        Mockito.when(repository.findById(idExistente)).thenReturn(Optional.of(genero));
        Mockito.when(repository.findById(idNaoExistente)).thenReturn(Optional.empty());

        Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(genero);

        Mockito.when(repository.getReferenceById(idExistente)).thenReturn(genero);
        Mockito.when(repository.getReferenceById(idNaoExistente)).thenThrow(EntityNotFoundException.class);

        Mockito.doNothing().when(repository).deleteById(idExistente);
        Mockito.doThrow(EmptyResultDataAccessException.class).when(repository).deleteById(idNaoExistente);
        Mockito.doThrow(DataIntegrityViolationException.class).when(repository).deleteById(idChaveEstrangeira);
    }

    @Test
    public void procurarTodosDeveriaRetornarUmaListaDeObjetos() {
        List<GeneroDto> list = service.procurarTodos();
        Assertions.assertNotNull(list);
        Mockito.verify(repository, times(1)).findAll();
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmProdutoQuandoOIdExistir() {
        GeneroDto resultado = service.procurarPorId(idExistente);
        Assertions.assertNotNull(resultado);
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmaExcecaoQuandoOIdNaoExistir() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.procurarPorId(idNaoExistente);
        });
        Mockito.verify(repository, times(1)).findById(idNaoExistente);
    }

    @Test
    public void inserirDeveriaGravarUmObjetoNoBancoDeDados() {
        GeneroDto resultado = service.inserir(generoDto);
        Assertions.assertNotNull(resultado);
    }

    @Test
    public void atualizarDeveriaGravarNovamenteUmMesmoObjeto() {
        GeneroDto resultado = service.atualizar(idExistente, generoDto);
        Assertions.assertNotNull(resultado);
    }

    @Test
    public void atualizarDeveriaLancarUmaExcecaoQuandoOIdNaoExistir() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.atualizar(idNaoExistente, generoDto);
        });
    }

    @Test
    public void excluirDeveriaDeletarUmObjeto() {
        Assertions.assertDoesNotThrow(() -> {
            service.excluir(idExistente);
        });
    }

    @Test
    public void excluirDeveriaLancarUmaExcecaoDeIdNaoEncontrado() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.excluir(idNaoExistente);
        });
        Mockito.verify(repository, times(1)).deleteById(idNaoExistente);
    }

    @Test
    public void excluirDeveriaLancarUmaExcecaoDeIntegridadeDeBancoDeDados() {
        Assertions.assertThrows(IntegridadeBD.class, () -> {
            service.excluir(idChaveEstrangeira);
        });
        Mockito.verify(repository, times(1)).deleteById(idChaveEstrangeira);
    }
}




