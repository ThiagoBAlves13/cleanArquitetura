package br.com.alura.codechella.domain.entities.usuario;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("12345678900", "Thiago", LocalDate.parse("1984-07-13"), "thiago@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456789-00", "Thiago", LocalDate.parse("1984-07-13"), "thiago@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("", "Thiago", LocalDate.parse("1984-07-13"), "thiago@email.com"));

    }

    @Test
    public void naoDeveCadastrarUsuarioComMenosDe18anos() {
        LocalDate dataNascimento = LocalDate.now().minusYears(17);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("123.456.789-00", "Fulano", dataNascimento, "fulano@example.com");
        });
    
        Assertions.assertEquals("Usuário deve ter pelo menos 18 anos de idade!", exception.getMessage());
    }


    @Test
    public void deveCriarUsuarioComFabrica(){

        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimento("Thiago", "123.456.789-00" , LocalDate.parse("1984-07-13"));

        Assertions.assertEquals("Thiago", usuario.getNome());
        Assertions.assertEquals("123.456.789-00", usuario.getCpf());
        Assertions.assertEquals(LocalDate.parse("1984-07-13"), usuario.getNascimento());

        usuario = fabrica.incluiEndereco("25636-000", 26523, "sem saída");
        Assertions.assertEquals("25636-000",usuario.getEndereco().getCep());
        Assertions.assertEquals( 26523, usuario.getEndereco().getNumero());
        Assertions.assertEquals( "sem saída", usuario.getEndereco().getComplemento());
    }
}
