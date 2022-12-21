package Rios.Vinicius.musica.repositories;

import Rios.Vinicius.musica.entities.Estado;
import Rios.Vinicius.musica.test.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class EstadoRepositoryTests {

    @Autowired
    private EstadoRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeEstados;

    @BeforeEach
    void Setup() throws Exception{

        idExistente = 1L;
        idNaoExistente = 999L;
        contagemTotalDeEstados = 6L;
    }

    @Test
    public void deleteDeveriaExcluirOObjetoQaundoOIdExistir() {
        repository.deleteById(idExistente);
        Optional<Estado> resultado = repository.findById(idExistente);
        Assertions.assertFalse(resultado.isPresent());// Existe um objeto "Estado" dentro de resultado gravado na linha de cima

    }
    @Test
    public void deleteDeveriaLancarExcecaoSeOIdNaoExistir() {

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
    public void procurarPorIdDeveriaRetornarUmOptionalComUmObjeto(){

        Optional <Estado> resultado = repository.findById(idExistente);
        Assertions.assertTrue(resultado.isPresent());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmOptionalVazio(){
        Optional<Estado> resultado = repository.findById(idNaoExistente);
    }


}





