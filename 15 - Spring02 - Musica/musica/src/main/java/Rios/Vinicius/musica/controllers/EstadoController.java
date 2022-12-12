package Rios.Vinicius.musica.controllers;

import Rios.Vinicius.musica.dtos.EstadoDto;
import Rios.Vinicius.musica.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {


    @Autowired
    private EstadoService service;


    //Lista todos os Estadoes DTO recebidos de EstadoService e disponibiliza para o front end
    @GetMapping
    public ResponseEntity<List<EstadoDto>> buscarTodos(){
        List<EstadoDto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    //listar um Estado por ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<EstadoDto> buscarPorId(@PathVariable Long id){
        EstadoDto dto = service.proucurarPorId(id);
        return ResponseEntity.ok().body(dto);
    }
    //Cadastrar um Estado
    @PostMapping
    public ResponseEntity<EstadoDto> inserir (@RequestBody EstadoDto dto){
        dto = service.inserir(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    //Atualizar um Estado
    @PutMapping(value = "/{id}")
    public ResponseEntity<EstadoDto> atualizar(@PathVariable Long id,@RequestBody EstadoDto dto){
            dto = service.atualizar(id, dto);
            return ResponseEntity.ok().body(dto);

    }


    //Deletar um Estado
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
