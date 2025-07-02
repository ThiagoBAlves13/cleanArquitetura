package br.com.alura.codechella.infra.gateways;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository repositorio;
    private final UsuarioEntityMapper usuarioMapper;

    public RepositorioDeUsuarioJpa(UsuarioRepository repositorio, UsuarioEntityMapper usuarioMapper) {
        this.repositorio = repositorio;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity entity = usuarioMapper.toEntity(usuario);
        repositorio.save(entity);
        return usuarioMapper.toDomanain(entity);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repositorio.findAll().stream().map(usuarioMapper::toDomanain).collect(Collectors.toList());
    }

}
