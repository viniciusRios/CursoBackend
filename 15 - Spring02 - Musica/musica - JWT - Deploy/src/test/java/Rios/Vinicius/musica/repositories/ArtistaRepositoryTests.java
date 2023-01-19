package Rios.Vinicius.musica.repositories;

import Rios.Vinicius.musica.entities.Artista;
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
public class ArtistaRepositoryTests {

    @Autowired
    private ArtistaRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeArtistas;
    private List<Artista> artistaList = new ArrayList<>();

    @BeforeEach
    void Setup() throws Exception{

        idExistente = 1L;
        idNaoExistente = 999L;
        contagemTotalDeArtistas = 4L;

    }

    @Test
    public void saveDeveriaPersistirComAutoincrementoQuandoOIdForNulo(){
        Artista artista = FactoryFK.criarArtista();
        artista.setId(null);
        artista = repository.save(artista);
        Assertions.assertNotNull(artista.getId());
        Assertions.assertEquals(contagemTotalDeArtistas+1, artista.getId());
    }
    @Test
    public void findAllDeveriaRetornarUmaListaDeObjetos(){
        artistaList = repository.findAll();
        Assertions.assertNotNull(artistaList);
    }
    @Test
    public void findByIdDeveriaRetornarUmOptionalComUmObjeto(){

        Optional <Artista> resultado = repository.findById(idExistente);
        Assertions.assertTrue(resultado.isPresent());
    }
    @Test
    public void findByIdDeveriaRetornarUmOptionalVazio(){
        Optional<Artista> resultado = repository.findById(idNaoExistente);
        Assertions.assertTrue(resultado.isEmpty());
    }
    @Test
    public void deleteDeveriaExcluirOObjetoQaundoOIdExistir() {
        repository.deleteById(idExistente);
        Optional<Artista> resultado = repository.findById(idExistente);
        Assertions.assertFalse(resultado.isPresent());// Existe um objeto "Artista" dentro de resultado gravado na linha de cima

    }
    @Test
    public void deleteDeveriaLancarExcecaoSeOIdNaoExistir() {

          Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(idNaoExistente);
            });
//
    }








}





