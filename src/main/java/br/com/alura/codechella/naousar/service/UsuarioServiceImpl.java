package br.com.alura.codechella.naousar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.codechella.naousar.model.Usuario;
import br.com.alura.codechella.naousar.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repository.findAll();
    }
}
