package Rios.Vinicius.musica.repositories;

import Rios.Vinicius.musica.entities.Festival;
import Rios.Vinicius.musica.test.FactoryFK;
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
public class FestivalRepositoryTests {

    @Autowired
    private FestivalRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeFestivals;
    private List<Festival> festivalList = new ArrayList<>();

    @BeforeEach
    void Setup() throws Exception{

        idExistente = 1L;
        idNaoExistente = 999L;
        contagemTotalDeFestivals = 5L;

    }

    @Test
    public void saveDeveriaPersistirComAutoincrementoQuandoOIdForNulo(){
        Festival festival = FactoryFK.criarFestival();
        festival.setId(null);
        festival = repository.save(festival);
        Assertions.assertNotNull(festival.getId());
        Assertions.assertEquals(contagemTotalDeFestivals+1, festival.getId());
    }
    @Test
    public void findAllDeveriaRetornarUmaListaDeObjetos(){
        festivalList = repository.findAll();
        Assertions.assertNotNull(festivalList);
    }
    @Test
    public void findByIdDeveriaRetornarUmOptionalComUmObjeto(){

        Optional <Festival> resultado = repository.findById(idExistente);
        Assertions.assertTrue(resultado.isPresent());
    }
    @Test
    public void findByIdDeveriaRetornarUmOptionalVazio(){
        Optional<Festival> resultado = repository.findById(idNaoExistente);
        Assertions.assertTrue(resultado.isEmpty());
    }
    @Test
    public void deleteDeveriaExcluirOObjetoQaundoOIdExistir() {
        repository.deleteById(idExistente);
        Optional<Festival> resultado = repository.findById(idExistente);
        Assertions.assertFalse(resultado.isPresent());// Existe um objeto "Festival" dentro de resultado gravado na linha de cima

    }
    @Test
    public void deleteDeveriaLancarExcecaoSeOIdNaoExistir() {

          Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(idNaoExistente);
            });
//
    }








}





