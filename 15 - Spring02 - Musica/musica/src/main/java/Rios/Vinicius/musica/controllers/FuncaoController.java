package Rios.Vinicius.musica.controllers;

import Rios.Vinicius.musica.dtos.FuncaoDto;
import Rios.Vinicius.musica.services.FuncaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/funcoes")
public class FuncaoController {


    @Autowired
    private FuncaoService service;


    //Lista todos os funcoes DTO recebidos de FuncaoService e disponibiliza para o front end
    @GetMapping
    public ResponseEntity<List<FuncaoDto>> buscarTodos(){
        List<FuncaoDto> list = service.procurarTodos();
        return ResponseEntity.ok().body(list);
    }

    //listar um funcao por ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<FuncaoDto> buscarPorId(@PathVariable Long id){
        FuncaoDto dto = service.procurarPorId(id);
        return ResponseEntity.ok().body(dto);
    }
    //Cadastrar um funcao
    @PostMapping
    public ResponseEntity<FuncaoDto> inserir (@RequestBody FuncaoDto dto){
        dto = service.inserir(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    //Atualizar um funcao
    @PutMapping(value = "/{id}")
    public ResponseEntity<FuncaoDto> atualizar(@PathVariable Long id,@RequestBody FuncaoDto dto){
            dto = service.atualizar(id, dto);
            return ResponseEntity.ok().body(dto);

    }


    //Deletar um funcao
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
