package br.com.alura.codechella.infra.gateways;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class RepositorioUsuarioArquivo implements RepositorioDeUsuario {

    List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        return usuario;
    }

    @Override
    public List<Usuario> listarTodos() {
        return this.usuarios;
    }

    public void gravaEmArquivo(String nomeArquivo) {

        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(nomeArquivo);

            fileWriter.write(this.usuarios.toString());
            fileWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
