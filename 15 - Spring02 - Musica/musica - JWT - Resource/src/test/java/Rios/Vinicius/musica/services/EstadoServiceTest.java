package Rios.Vinicius.musica.services;

import Rios.Vinicius.musica.dtos.EstadoDto;
import Rios.Vinicius.musica.entities.Estado;
import Rios.Vinicius.musica.repositories.EstadoRepository;
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
public class EstadoServiceTest {

    @InjectMocks
    private EstadoService service;

    @Mock
    private EstadoRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeEstadoes;
    private Long idChaveEstrangeira;
    private List<Estado> estadoList = new ArrayList<>();
    private Estado estado;
    private EstadoDto estadoDto;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 999L;
        idChaveEstrangeira = 2L;
        contagemTotalDeEstadoes = 5L;
        estado = Factory.criarEstado();
        estadoDto = Factory.criarEstadoDto();
        estadoList = new ArrayList<>();

        // Simulações da camada de repository;
        Mockito.when(repository.findAll()).thenReturn(estadoList);

        Mockito.when(repository.findById(idExistente)).thenReturn(Optional.of(estado));
        Mockito.when(repository.findById(idNaoExistente)).thenReturn(Optional.empty());

        Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(estado);

        Mockito.when(repository.getReferenceById(idExistente)).thenReturn(estado);
        Mockito.when(repository.getReferenceById(idNaoExistente)).thenThrow(EntityNotFoundException.class);

        Mockito.doNothing().when(repository).deleteById(idExistente);
        Mockito.doThrow(EmptyResultDataAccessException.class).when(repository).deleteById(idNaoExistente);
        Mockito.doThrow(DataIntegrityViolationException.class).when(repository).deleteById(idChaveEstrangeira);
    }

    @Test
    public void procurarTodosDeveriaRetornarUmaListaDeObjetos() {
        List<EstadoDto> list = service.procurarTodos();
        Assertions.assertNotNull(list);
        Mockito.verify(repository, times(1)).findAll();
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmProdutoQuandoOIdExistir() {
        EstadoDto resultado = service.procurarPorId(idExistente);
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
        EstadoDto resultado = service.inserir(estadoDto);
        Assertions.assertNotNull(resultado);
    }

    @Test
    public void atualizarDeveriaGravarNovamenteUmMesmoObjeto() {
        EstadoDto resultado = service.atualizar(idExistente, estadoDto);
        Assertions.assertNotNull(resultado);
    }

    @Test
    public void atualizarDeveriaLancarUmaExcecaoQuandoOIdNaoExistir() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.atualizar(idNaoExistente, estadoDto);
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




