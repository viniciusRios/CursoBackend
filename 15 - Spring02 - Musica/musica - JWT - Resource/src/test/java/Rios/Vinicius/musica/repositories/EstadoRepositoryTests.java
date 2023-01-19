package Rios.Vinicius.musica.repositories;

import Rios.Vinicius.musica.entities.Estado;
import Rios.Vinicius.musica.test.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class EstadoRepositoryTests {

    @Autowired
    private EstadoRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeEstados;
    private List<Estado> estadoList= new ArrayList<>();

    @BeforeEach
    void Setup() throws Exception{

        idExistente = 1L;
        idNaoExistente = 999L;
        contagemTotalDeEstados = 7L;
    }

    @Test
    public void deleteByIdDeveriaExcluirOObjetoQaundoOIdExistir() {
        repository.deleteById(idExistente);
        Optional<Estado> resultado = repository.findById(idExistente);
        Assertions.assertFalse(resultado.isPresent());// Existe um objeto "Estado" dentro de resultado gravado na linha de cima

    }
    @Test
    public void deleteByIdDeveriaLancarExcecaoSeOIdNaoExistir() {

          Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(idNaoExistente);
            });
//
    }

    @Test
    public void saveDeveriaPersistirComAutoincrementoQuandoOIdForNulo(){
        Estado estado = Factory.criarEstado();
        estado.setId(null);
        estado = repository.save(estado);
        Assertions.assertNotNull(estado.getId());
        Assertions.assertEquals(contagemTotalDeEstados+1, estado.getId());
    }

    @Test
    public void findAllDeveriaRetornarUmaListaDeObjetos(){
        estadoList = repository.findAll();
        Assertions.assertNotNull(estadoList);
    }

    @Test
    public void findByIdDeveriaRetornarUmOptionalComUmObjeto(){

        Optional <Estado> resultado = repository.findById(idExistente);
        Assertions.assertTrue(resultado.isPresent());
    }

    @Test
    public void findByIdDeveriaRetornarUmOptionalVazio(){
        Optional<Estado> resultado = repository.findById(idNaoExistente);
    }


}





