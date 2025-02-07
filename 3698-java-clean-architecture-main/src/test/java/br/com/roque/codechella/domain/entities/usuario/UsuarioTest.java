package br.com.roque.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
     void naoDeveCadatrarUsuarioCom_CPF_NoFormatoInvalido(){
        assertThrows(IllegalArgumentException.class,
                ()-> new Usuario( "Tadeu","12345678999", LocalDate.parse("1978-11-09"),"teste@teste.com"));
    }
    @Test
     void naoDeveCadatrarUsuarioCom_CPF_NotFound(){
        assertThrows(IllegalArgumentException.class,
                ()-> new Usuario( "","Tadeu ", LocalDate.parse("1978-11-09"),"teste@teste.com"));
    }
    @Test
     void naoDeveCadatrarUsuarioCom_Email_NoFormatoInvalido(){
        assertThrows(IllegalArgumentException.class,
                ()-> new Usuario("12345678999", "Tadeu", LocalDate.parse("1978-11-09"),"testeteste.com"));
    }

    @Test
     void testSetNascimento_NullDate() {
        Usuario usuario = new Usuario();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            usuario.setNascimento(null);
        });
        assertEquals("Data de nascimento não pode ser nula", exception.getMessage());
    }

    @Test
     void testSetNascimento_Underage() {
        Usuario usuario = new Usuario();
        LocalDate underageDate = LocalDate.now().minusYears(17);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            usuario.setNascimento(underageDate);
        });
        assertEquals("Usuário deve ter pelo menos 18 anos para se cadastrar", exception.getMessage());
    }

    @Test
     void testSetNascimento_ValidDate() {
        Usuario usuario = new Usuario();
        LocalDate validDate = LocalDate.now().minusYears(20);
        assertDoesNotThrow(() -> {
            usuario.setNascimento(validDate);
        });
        assertEquals(validDate, usuario.getNascimento());
    }
    @Test
     void deveCriarUsuarioComAFabrica(){
        FabricaUsuario fabricaUsuario = new FabricaUsuario();
        Usuario usuario = fabricaUsuario.comNomeCpfNascimento( "654.123.897-88", "Tadeu",LocalDate.parse("2012-11-20"),"teste@teste.com");

        assertEquals("Tadeu",usuario.getNome());
        usuario = fabricaUsuario.incluiEndereco("12345-999", 40, "apto XPTO");

        assertEquals("apto XPTO",usuario.getEndereco().getComplemento() );
    }

}