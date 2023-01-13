package Rios.Vinicius.musica.services;

import Rios.Vinicius.musica.dtos.ArtistaDto;
import Rios.Vinicius.musica.dtos.UsuarioDto;
import Rios.Vinicius.musica.entities.*;
import Rios.Vinicius.musica.repositories.FuncaoRepository;
import Rios.Vinicius.musica.repositories.UsuarioRepository;
import Rios.Vinicius.musica.services.exceptions.RecursoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsuarioService implements UserDetailsService {

    @Autowired// Injeção de dependencias
    private UsuarioRepository repository;

    @Autowired// Injeção de dependencias
    private FuncaoRepository Funcaorepository;

    @Transactional(readOnly = true)
    public List<UsuarioDto> procurarTodos() {
        List<Usuario> list = repository.findAll();
        // Expressão Lambda ou Alta ordem
        return list.stream().map(x -> new UsuarioDto(x)).collect(Collectors.toList());
    } // Retorna uma lista de PaisDto para o Controller

    @Transactional(readOnly = true)
    public UsuarioDto procurarPorId(Long id) {
        Optional<Usuario> objeto = repository.findById(id);
        Usuario entidade = objeto.orElseThrow(() ->
                new RecursoNaoEncontrado("Este ID não existe em nosso sistema.")
        );
        return new UsuarioDto(entidade);
    }

    @Transactional(readOnly = true)
    public UsuarioDto inserir (UsuarioDto dto){
        Usuario entidade = new Usuario();



        entidade = repository.save(entidade);
        return new UsuarioDto(entidade);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

}
