package Rios.Vinicius.musica.controllers;

import Rios.Vinicius.musica.dtos.GeneroDto;
import Rios.Vinicius.musica.services.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/generos")
public class GeneroController {


    @Autowired
    private GeneroService service;


    //Lista todos os Generoes DTO recebidos de GeneroService e disponibiliza para o front end
    @GetMapping
    public ResponseEntity<List<GeneroDto>> buscarTodos(){
        List<GeneroDto> list = service.procurarTodos();
        return ResponseEntity.ok().body(list);
    }

    //listar um Genero por ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<GeneroDto> buscarPorId(@PathVariable Long id){
        GeneroDto dto = service.procurarPorId(id);
        return ResponseEntity.ok().body(dto);
    }
    //Cadastrar um Genero
    @PostMapping
    public ResponseEntity<GeneroDto> inserir (@RequestBody GeneroDto dto){
        dto = service.inserir(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    //Atualizar um Genero
    @PutMapping(value = "/{id}")
    public ResponseEntity<GeneroDto> atualizar(@PathVariable Long id,@RequestBody GeneroDto dto){
            dto = service.atualizar(id, dto);
            return ResponseEntity.ok().body(dto);

    }


    //Deletar um Genero
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
