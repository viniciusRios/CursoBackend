package Rios.Vinicius.musica.repositories;

import Rios.Vinicius.musica.entities.Genero;
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
public class GeneroRepositoryTests {

    @Autowired
    private GeneroRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeGeneros;
    private List<Genero> generoList = new ArrayList<>();

    @BeforeEach
    void Setup() throws Exception{

        idExistente = 1L;
        idNaoExistente = 999L;
        contagemTotalDeGeneros = 9L;

    }

    @Test
    public void deleteDeveriaExcluirOObjetoQaundoOIdExistir() {
        repository.deleteById(idExistente);
        Optional<Genero> resultado = repository.findById(idExistente);
        Assertions.assertFalse(resultado.isPresent());// Existe um objeto "Genero" dentro de resultado gravado na linha de cima

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
        Genero genero = Factory.criarGenero();
        genero.setId(null);
        genero = repository.save(genero);
        Assertions.assertNotNull(genero.getId());
        Assertions.assertEquals(contagemTotalDeGeneros+1, genero.getId());
    }

    @Test
    public void findAllDeveriaRetornarUmaListaDeObjetos(){
        generoList = repository.findAll();
        Assertions.assertNotNull(generoList);
    }

    @Test
    public void findByIdDeveriaRetornarUmOptionalComUmObjeto(){

        Optional <Genero> resultado = repository.findById(idExistente);
        Assertions.assertTrue(resultado.isPresent());
    }

    @Test
    public void findByIdDeveriaRetornarUmOptionalVazio(){
        Optional<Genero> resultado = repository.findById(idNaoExistente);
    }


}





