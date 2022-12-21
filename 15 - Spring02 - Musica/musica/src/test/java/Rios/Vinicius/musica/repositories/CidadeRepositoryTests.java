package Rios.Vinicius.musica.repositories;

import Rios.Vinicius.musica.entities.Cidade;
import Rios.Vinicius.musica.test.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class CidadeRepositoryTests {

    @Autowired
    private CidadeRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeCidades;

    @BeforeEach
    void Setup() throws Exception{

        idExistente = 1L;
        idNaoExistente = 999L;
        contagemTotalDeCidades = 6L;
    }

    @Test
    public void deleteDeveriaExcluirOObjetoQaundoOIdExistir() {
        repository.deleteById(idExistente);
        Optional<Cidade> resultado = repository.findById(idExistente);
        Assertions.assertFalse(resultado.isPresent());// Existe um objeto "Cidade" dentro de resultado gravado na linha de cima

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
        Cidade cidade = Factory.criarCidade();
        cidade.setId(null);
        cidade = repository.save(cidade);
        Assertions.assertNotNull(cidade.getId());
        Assertions.assertEquals(contagemTotalDeCidades+1, cidade.getId());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmOptionalComUmObjeto(){

        Optional <Cidade> resultado = repository.findById(idExistente);
        Assertions.assertTrue(resultado.isPresent());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmOptionalVazio(){
        Optional<Cidade> resultado = repository.findById(idNaoExistente);
    }


}





