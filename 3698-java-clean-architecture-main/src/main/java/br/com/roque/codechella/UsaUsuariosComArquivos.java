package br.com.roque.codechella;

import br.com.roque.codechella.domain.entities.usuario.Usuario;
import br.com.roque.codechella.infra.gateways.RepositorioDeUsuariosEmArquivos;

import java.time.LocalDate;

public class UsaUsuariosComArquivos {
    /**
     * implementando a persistencia em memória sem alterar nada na aplicação
     */
    public static void main(String[] args) {
        RepositorioDeUsuariosEmArquivos usuariosEmArquivos = new RepositorioDeUsuariosEmArquivos();
        usuariosEmArquivos.cadastrarUsuario(new Usuario("789.456.123-99", "Luana", LocalDate.parse("2005-08-14"),"luana@gmail.com"));
        usuariosEmArquivos.cadastrarUsuario(new Usuario("789.456.123-99", "Wagner", LocalDate.parse("1978-08-09"),"wagner@gmail.com"));
        usuariosEmArquivos.cadastrarUsuario(new Usuario("789.456.123-99", "Tadeu", LocalDate.parse("1977-08-11"),"tadeu@gmail.com"));
        usuariosEmArquivos.cadastrarUsuario(new Usuario("789.456.123-99", "Wallace", LocalDate.parse("2005-08-14"),"wallace@gmail.com"));

//        System.out.println(usuariosEmArquivos.listarTodos());
    usuariosEmArquivos.gravarEmArquivos("usuarios.txt");
    }
}
