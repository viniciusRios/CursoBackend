package Rios.Vinicius.musica.controllers;

import Rios.Vinicius.musica.dtos.UsuarioAtualizarDto;
import Rios.Vinicius.musica.dtos.UsuarioDto;
import Rios.Vinicius.musica.dtos.UsuarioInserirDto;
import Rios.Vinicius.musica.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {


    @Autowired
    private UsuarioService service;


    //Lista todos os funcoes DTO recebidos de UsuarioService e disponibiliza para o front end
    @GetMapping
    public ResponseEntity<List<UsuarioDto>> buscarTodos(){
        List<UsuarioDto> list = service.procurarTodos();
        return ResponseEntity.ok().body(list);
    }

    //listar um usuario por ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDto> buscarPorId(@PathVariable Long id){
        UsuarioDto dto = service.procurarPorId(id);
        return ResponseEntity.ok().body(dto);
    }
    //Cadastrar um usuario
    @PostMapping
    public ResponseEntity<UsuarioDto> inserir (@RequestBody @Valid UsuarioInserirDto dto){
        UsuarioDto newdto = service.inserir(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(newdto);
    }

    //Atualizar um usuario
    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioDto> atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioAtualizarDto dto){
            UsuarioDto newdto = service.atualizar(id, dto);
            return ResponseEntity.ok().body(newdto);

    }


    //Deletar um usuario
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
