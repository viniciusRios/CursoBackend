package Rios.Vinicius.musica.repositories;

import Rios.Vinicius.musica.entities.Pais;
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
public class PaisRepositoryTests {

    @Autowired
    private PaisRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDePaises;
    private List<Pais> paisList = new ArrayList<>();

    @BeforeEach
    void Setup() throws Exception{

        idExistente = 1L;
        idNaoExistente = 999L;
        contagemTotalDePaises = 5L;

    }



    @Test
    public void saveDeveriaPersistirComAutoincrementoQuandoOIdForNulo(){
        Pais pais = Factory.criarPais();
        pais.setId(null);
        pais = repository.save(pais);
        Assertions.assertNotNull(pais.getId());
        Assertions.assertEquals(contagemTotalDePaises+1, pais.getId());
    }

    @Test
    public void findAllDeveriaRetornarUmaListaDeObjetos(){
        paisList = repository.findAll();
        Assertions.assertNotNull(paisList);
    }

    @Test
    public void findByIdDeveriaRetornarUmOptionalComUmObjeto(){

        Optional <Pais> resultado = repository.findById(idExistente);
        Assertions.assertTrue(resultado.isPresent());
    }

    @Test
    public void findByIdDeveriaRetornarUmOptionalVazio(){
        Optional<Pais> resultado = repository.findById(idNaoExistente);
    }

    @Test
    public void deleteDeveriaExcluirOObjetoQaundoOIdExistir() {
        repository.deleteById(idExistente);
        Optional<Pais> resultado = repository.findById(idExistente);
        Assertions.assertFalse(resultado.isPresent());// Existe um objeto "Pais" dentro de resultado gravado na linha de cima

    }
    @Test
    public void deleteDeveriaLancarExcecaoSeOIdNaoExistir() {

        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(idNaoExistente);
        });
//
    }

}





