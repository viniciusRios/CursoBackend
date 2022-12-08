package Rios.Vinicius.musica.controllers;

import Rios.Vinicius.musica.dtos.PaisDto;
import Rios.Vinicius.musica.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/paises")
public class PaisController {


    @Autowired
    private PaisService service;


    //Lista todos os paises DTO recebidos de PaisService e disponibiliza para o front end
    @GetMapping
    public ResponseEntity<List<PaisDto>> buscarTodos(){
        List<PaisDto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    //listar um pais por ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<PaisDto> buscarPorId(@PathVariable Long id){
        PaisDto dto = service.proucurarPorId(id);
        return ResponseEntity.ok().body(dto);
    }
    //Cadastrar um pais
    @PostMapping
    public ResponseEntity<PaisDto> inserir (@RequestBody PaisDto dto){
        dto = service.inserir(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    //Atualizar um pais

    //Deletar um pais


}
