package Rios.Vinicius.musica.services;

import Rios.Vinicius.musica.dtos.FuncaoDto;
import Rios.Vinicius.musica.dtos.UsuarioAtualizarDto;
import Rios.Vinicius.musica.dtos.UsuarioDto;
import Rios.Vinicius.musica.dtos.UsuarioInserirDto;
import Rios.Vinicius.musica.entities.Funcao;
import Rios.Vinicius.musica.entities.Usuario;
import Rios.Vinicius.musica.repositories.FuncaoRepository;
import Rios.Vinicius.musica.repositories.UsuarioRepository;
import Rios.Vinicius.musica.services.exceptions.IntegridadeBD;
import Rios.Vinicius.musica.services.exceptions.RecursoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired // Injeção de dependência
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired // Injeção de dependência
    private UsuarioRepository repository;

    @Autowired // Injeção de dependência
    private FuncaoRepository funcaoRepository;

    @Transactional(readOnly = true)
    public List<UsuarioDto> procurarTodos() {
        List<Usuario> list = repository.findAll();
        return list.stream().map(x -> new UsuarioDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UsuarioDto procurarPorId(Long id) {
        Optional<Usuario> objeto = repository.findById(id);
        Usuario entidade = objeto.orElseThrow(() ->
                new RecursoNaoEncontrado("Este ID não existe em nosso sistema.")
        );
        return new UsuarioDto(entidade);
    }

    @Transactional
    public UsuarioDto inserir(UsuarioInserirDto dto) {
        Usuario entidade = new Usuario();
        copiarDtoParaEntidade(dto, entidade);
        entidade.setSenha(passwordEncoder.encode(dto.getSenha())); // Será criptografado aqui
        entidade = repository.save(entidade);
        return new UsuarioDto(entidade);
    }

    @Transactional
    public UsuarioDto atualizar(Long id, UsuarioAtualizarDto dto) {
        try {
            Usuario entidade = repository.getReferenceById(id);
            copiarDtoParaEntidade(dto, entidade);
            entidade = repository.save(entidade);
            return new UsuarioDto(entidade);
        }
        catch (EntityNotFoundException e) {
            throw new RecursoNaoEncontrado("Id não encontradoi: " + id);
        }
    }

    public void excluir(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new RecursoNaoEncontrado("Id não encontrado: " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new IntegridadeBD("Violação de integridade no banco de dados.");
        }
    }

    private void copiarDtoParaEntidade(UsuarioDto dto, Usuario entidade) {
        entidade.setNome(dto.getNome());
        entidade.setSobrenome(dto.getSobrenome());
        entidade.setEmail(dto.getEmail());

        entidade.getFuncoes().clear();
        for (FuncaoDto funcDto : dto.getFuncoes()) {
            Funcao func = funcaoRepository.getReferenceById(funcDto.getId());
            entidade.getFuncoes().add(func);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("E-mail inexistente!");
        }
        return usuario;
    }
}
