package br.com.roque.codechella.application.gateways;

import br.com.roque.codechella.domain.entities.usuario.Usuario;

import java.util.List;

public interface RepositorioDeUsuario {
    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();

    Usuario alteraUsuario(String cpf, Usuario usuario);

    void excluiUsuario(String cpf);
}
