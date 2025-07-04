package br.com.alura.codechella;

import java.time.LocalDate;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioUsuarioArquivo;

public class UtilizaUsuarioComArquivo {

    public static void main(String[] args) {

        RepositorioUsuarioArquivo repositorioUsuarioArquivo = new RepositorioUsuarioArquivo();

        repositorioUsuarioArquivo.cadastrarUsuario(new Usuario("456.123.789-22", "João", LocalDate.parse("2000-01-01"), "joao@email.com"));
        repositorioUsuarioArquivo.cadastrarUsuario(new Usuario("456.123.789-22", "Maria", LocalDate.parse("2000-01-01"), "joao@email.com"));
        repositorioUsuarioArquivo.cadastrarUsuario(new Usuario("456.123.789-22", "Pedro", LocalDate.parse("2000-01-01"), "joao@email.com"));
        repositorioUsuarioArquivo.cadastrarUsuario(new Usuario("456.123.789-22", "Ana", LocalDate.parse("2000-01-01"), "joao@email.com"));

        //System.err.println(repositorioUsuarioArquivo.listarTodos()); 
        repositorioUsuarioArquivo.gravaEmArquivo("usuario.txt");
    }

}
