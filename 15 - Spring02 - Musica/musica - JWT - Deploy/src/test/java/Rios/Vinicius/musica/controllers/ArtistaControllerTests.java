package Rios.Vinicius.musica.controllers;

import Rios.Vinicius.musica.dtos.ArtistaDto;
import Rios.Vinicius.musica.services.ArtistaService;
import Rios.Vinicius.musica.services.exceptions.RecursoNaoEncontrado;
import Rios.Vinicius.musica.test.FactoryFK;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArtistaController.class)
public class ArtistaControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArtistaService service; // cria uma simulação

    @Autowired
    private ObjectMapper objectMapper;

    private Long idExistente;
    private Long idNaoExistente;
    private Long idChaveExtrangeira;
    private ArtistaDto artistaDto;
    private List<ArtistaDto> artistaDtoList;


    @BeforeEach
    void setup() throws Exception{
         idExistente = 1L;
          idNaoExistente = 2L;
          idChaveExtrangeira = 3L;
          artistaDto = FactoryFK.criarArtistaDto();
          artistaDtoList = new ArrayList<>();

        when(service.procurarTodos()).thenReturn(artistaDtoList);

        when(service.procurarPorId(idExistente)).thenReturn(artistaDto);
        when(service.procurarPorId(idNaoExistente)).thenThrow(RecursoNaoEncontrado.class);

        when(service.inserir(any())).thenReturn(artistaDto);

        when(service.atualizar(eq(idExistente), any())).thenReturn(artistaDto);
        when(service.atualizar(eq(idNaoExistente), any()))
                .thenThrow(RecursoNaoEncontrado.class);

        doNothing().when(service).excluir(idExistente);
        doThrow(RecursoNaoEncontrado.class).when(service).excluir(idNaoExistente);
    }

    @Test
    public void inserirDeveriaRetornarUm201Dto() throws Exception {

        String jsonBody = objectMapper.writeValueAsString(artistaDto);

        ResultActions resultado = mockMvc.perform(post("/artistas")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isCreated());
        resultado.andExpect(jsonPath("$.id").exists());
        resultado.andExpect(jsonPath("$.nome").exists());
        resultado.andExpect(jsonPath("$.banda").exists());
        resultado.andExpect(jsonPath("$.estado_id").exists());
        resultado.andExpect(jsonPath("$.cidade_id").exists());
        resultado.andExpect(jsonPath("$.genero_id").exists());
    }

    @Test
    public void procurarTodosDeveriaRetonarUmaLista() throws Exception {

        ResultActions resultado = mockMvc.perform(get("/artistas")
                .accept(MediaType.APPLICATION_JSON));
        resultado.andExpect(status().isOk());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUm200QuandoOIdExistir() throws Exception {

        ResultActions resultado = mockMvc
                .perform(get("/artistas/{id}", idExistente)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isOk());
        resultado.andExpect(jsonPath("$.id").exists());
        resultado.andExpect(jsonPath("$.nome").exists());
        resultado.andExpect(jsonPath("$.banda").exists());
        resultado.andExpect(jsonPath("$.estado_id").exists());
        resultado.andExpect(jsonPath("$.cidade_id").exists());
        resultado.andExpect(jsonPath("$.genero_id").exists());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUm404QuandoOIdNaoExistir() throws Exception {

        ResultActions resultado = mockMvc
                .perform(get("/artistas/{id}", idNaoExistente)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isNotFound());
    }

    @Test
    public void atualizarDeveriaRetornarUm200DtoQuandoOIdExistir() throws Exception {

        String jsonBody = objectMapper.writeValueAsString(artistaDto);

        ResultActions resultado = mockMvc
                .perform(put("/artistas/{id}", idExistente)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isOk());
        resultado.andExpect(jsonPath("$.id").exists());
        resultado.andExpect(jsonPath("$.nome").exists());
        resultado.andExpect(jsonPath("$.banda").exists());
        resultado.andExpect(jsonPath("$.estado_id").exists());
        resultado.andExpect(jsonPath("$.cidade_id").exists());
        resultado.andExpect(jsonPath("$.genero_id").exists());
    }

    @Test
    public void atualizarDeveriaRetornarUm404DtoQuandoOIdNaoExistir() throws Exception {

        String jsonBody = objectMapper.writeValueAsString(artistaDto);

        ResultActions resultado = mockMvc
                .perform(put("/artistas/{id}", idNaoExistente)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isNotFound());
    }

    @Test
    public void excluirDeveriaRetornarUm204QuandoOIdExistir() throws Exception {

        ResultActions resultado = mockMvc
                .perform(delete("/artistas/{id}", idExistente)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isNoContent());
    }

    @Test
    public void excluirDeveriaRetornarUm404QuandoOIdNaoExistir() throws Exception {

        ResultActions resultado = mockMvc
                .perform(delete("/artistas/{id}", idNaoExistente)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isNotFound());
    }



}
