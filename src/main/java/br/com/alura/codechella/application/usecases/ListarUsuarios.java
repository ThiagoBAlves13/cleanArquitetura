package br.com.alura.codechella.application.usecases;

import java.util.List;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class ListarUsuarios {

    private final RepositorioDeUsuario repositorioDeUsuario;

    public ListarUsuarios(RepositorioDeUsuario repositorioDeUsuario){
        this.repositorioDeUsuario = repositorioDeUsuario;
    }

    public List<Usuario> obterTodosUsuarios(){
        return repositorioDeUsuario.listarTodos();
    }
}
