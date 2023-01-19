package Rios.Vinicius.musica.repositories;

import Rios.Vinicius.musica.entities.Album;
import Rios.Vinicius.musica.test.Factory;
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
public class AlbumRepositoryTests {

    @Autowired
    private AlbumRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeAlbums;
    private List<Album> albumList = new ArrayList<>();

    @BeforeEach
    void Setup() throws Exception{

        idExistente = 1L;
        idNaoExistente = 999L;
        contagemTotalDeAlbums = 39L;

    }

    @Test
    public void saveDeveriaPersistirComAutoincrementoQuandoOIdForNulo(){
        Album album = FactoryFK.criarAlbum();
        album.setId(null);
        album = repository.save(album);
        Assertions.assertNotNull(album.getId());
        Assertions.assertEquals(contagemTotalDeAlbums+1, album.getId());
    }
    @Test
    public void findAllDeveriaRetornarUmaListaDeObjetos(){
        albumList = repository.findAll();
        Assertions.assertNotNull(albumList);
    }
    @Test
    public void findByIdDeveriaRetornarUmOptionalComUmObjeto(){

        Optional <Album> resultado = repository.findById(idExistente);
        Assertions.assertTrue(resultado.isPresent());
    }
    @Test
    public void findByIdDeveriaRetornarUmOptionalVazio(){
        Optional<Album> resultado = repository.findById(idNaoExistente);
    }
    @Test
    public void deleteDeveriaExcluirOObjetoQaundoOIdExistir() {
        repository.deleteById(idExistente);
        Optional<Album> resultado = repository.findById(idExistente);
        Assertions.assertFalse(resultado.isPresent());// Existe um objeto "Album" dentro de resultado gravado na linha de cima

    }
    @Test
    public void deleteDeveriaLancarExcecaoSeOIdNaoExistir() {

          Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(idNaoExistente);
            });
//
    }








}





