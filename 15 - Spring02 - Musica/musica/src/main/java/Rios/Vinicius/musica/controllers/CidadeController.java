package Rios.Vinicius.musica.controllers;

import Rios.Vinicius.musica.dtos.CidadeDto;
import Rios.Vinicius.musica.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {


    @Autowired
    private CidadeService service;


    //Lista todos os Cidadees DTO recebidos de CidadeService e disponibiliza para o front end
    @GetMapping
    public ResponseEntity<List<CidadeDto>> buscarTodos(){
        List<CidadeDto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    //listar um Cidade por ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<CidadeDto> buscarPorId(@PathVariable Long id){
        CidadeDto dto = service.proucurarPorId(id);
        return ResponseEntity.ok().body(dto);
    }
    //Cadastrar um Cidade
    @PostMapping
    public ResponseEntity<CidadeDto> inserir (@RequestBody CidadeDto dto){
        dto = service.inserir(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    //Atualizar um Cidade
    @PutMapping(value = "/{id}")
    public ResponseEntity<CidadeDto> atualizar(@PathVariable Long id,@RequestBody CidadeDto dto){
            dto = service.atualizar(id, dto);
            return ResponseEntity.ok().body(dto);

    }


    //Deletar um Cidade
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
