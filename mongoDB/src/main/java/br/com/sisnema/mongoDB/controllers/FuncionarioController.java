package br.com.sisnema.mongoDB.controllers;

import br.com.sisnema.mongoDB.Services.FuncionarioService;
import br.com.sisnema.mongoDB.Services.SetorService;
import br.com.sisnema.mongoDB.entities.Funcionario;
import br.com.sisnema.mongoDB.entities.Setor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

        @Autowired
        private FuncionarioService funcionario;

        @PostMapping
         public Funcionario criar (@RequestBody Funcionario funcionario){
            return this.funcionario.criar(funcionario);
        }


        @GetMapping
        public List<Funcionario> obterTodos(){
            return this.funcionario.obterTodos();
        }

        @GetMapping(value = "/{codigo}")
        public Funcionario obterPorCodigo(@PathVariable String codigo){
            return this.funcionario.obterPorCodigo(codigo);
        }
}
