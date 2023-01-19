package Rios.Vinicius.musica.services;

import Rios.Vinicius.musica.dtos.PaisDto;
import Rios.Vinicius.musica.entities.Pais;
import Rios.Vinicius.musica.repositories.PaisRepository;
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
import org.springframework.test.web.servlet.ResultActions;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
public class PaisServiceTest {

    @InjectMocks
    private PaisService service;

    @Mock
    private PaisRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDePaises;
    private Long idChaveEstrangeira;
    private List<Pais> paisList = new ArrayList<>();
    private Pais pais;
    private PaisDto paisDto;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 999L;
        idChaveEstrangeira = 2L;
        contagemTotalDePaises = 5L;
        pais = Factory.criarPais();
        paisDto = Factory.criarPaisDto();
        paisList = new ArrayList<>();

        // Simulações da camada de repository;
        Mockito.when(repository.findAll()).thenReturn(paisList);

        Mockito.when(repository.findById(idExistente)).thenReturn(Optional.of(pais));
        Mockito.when(repository.findById(idNaoExistente)).thenReturn(Optional.empty());

        Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(pais);

        Mockito.when(repository.getReferenceById(idExistente)).thenReturn(pais);
        Mockito.when(repository.getReferenceById(idNaoExistente)).thenThrow(EntityNotFoundException.class);

        Mockito.doNothing().when(repository).deleteById(idExistente);
        Mockito.doThrow(EmptyResultDataAccessException.class).when(repository).deleteById(idNaoExistente);
        Mockito.doThrow(DataIntegrityViolationException.class).when(repository).deleteById(idChaveEstrangeira);
    }

    @Test
    public void procurarTodosDeveriaRetornarUmaListaDeObjetos() {
        List<PaisDto> list = service.procurarTodos();
        Assertions.assertNotNull(list);
        Mockito.verify(repository, times(1)).findAll();
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmProdutoQuandoOIdExistir() {
        PaisDto resultado = service.procurarPorId(idExistente);
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
        PaisDto resultado = service.inserir(paisDto);
        Assertions.assertNotNull(resultado);
    }

    @Test
    public void atualizarDeveriaGravarNovamenteUmMesmoObjeto() {
        PaisDto resultado = service.atualizar(idExistente, paisDto);
        Assertions.assertNotNull(resultado);
    }

    @Test
    public void atualizarDeveriaLancarUmaExcecaoQuandoOIdNaoExistir() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.atualizar(idNaoExistente, paisDto);
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

    @Test
    public void inserirDeveriaRetornarUm201Dto() throws Exception{

    }

    @Test
    public void procurarTodosDeveriaRetornarUmaLista() throws Exception{


    }


}




