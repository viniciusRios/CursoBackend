package Rios.Vinicius.musica.repositories;

import Rios.Vinicius.musica.entities.Cidade;
import Rios.Vinicius.musica.test.Factory;
import net.minidev.json.JSONUtil;
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
public class CidadeRepositoryTests {

    @Autowired
    private CidadeRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeCidades;
    private List<Cidade> cidadeList = new ArrayList<>();


    @BeforeEach
    void Setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 999L;
        contagemTotalDeCidades = 7L;
        System.out.println("pós Seeding :" +contagemTotalDeCidades);
    }

    @Test
    public void saveDeveriaPersistirComAutoincrementoQuandoOIdForNulo() {
        Cidade cidade = Factory.criarCidade();
        cidade.setId(null);
        cidade = repository.save(cidade);
        Assertions.assertNotNull(cidade.getId());
        System.out.println("pós CriarCidade e Pós Save Cidade :" +contagemTotalDeCidades);
        Assertions.assertEquals(contagemTotalDeCidades + 1, cidade.getId());
    }


    @Test
    public void findAllDeveriaRetornarUmaListaDeObjetos() {
        cidadeList = repository.findAll();
        Assertions.assertNotNull(cidadeList);
    }

    @Test
    public void findByIdDeveriaRetornarUmOptionalComUmObjeto() {
        Optional<Cidade> resultado = repository.findById(idExistente); // 1L
        Assertions.assertTrue(resultado.isPresent());
    }

    @Test
    public void findByIdDeveriaRetornarUmOptionalVazio() {
        Optional<Cidade> resultado = repository.findById(idNaoExistente); // 999L
        Assertions.assertTrue(resultado.isEmpty());
    }

    @Test
    public void deleteByIdDeveriaExcluirOObjetoQuandoOIdExistir() {
        repository.deleteById(idExistente);
        Optional<Cidade> resultado = repository.findById(idExistente);
        Assertions.assertFalse(resultado.isPresent()); // Cidade
        // Existe um objeto cidade aqui dentro?
    }

    @Test
    public void deleteByIdDeveriaLancarExcecaoSeOIdENaoxistir() {
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(idNaoExistente);
        });
    }
}



