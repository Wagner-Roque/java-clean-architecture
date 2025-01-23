package br.com.roque.codechella.application.usecases;

import br.com.roque.codechella.application.gateways.RepositorioDeUsuario;
import br.com.roque.codechella.domain.entities.usuario.Usuario;


import java.util.List;

public class ListarUsuario {
    private final RepositorioDeUsuario repositorioDeUsuario;

    public ListarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        this.repositorioDeUsuario = repositorioDeUsuario;
    }
    public List<Usuario> listarTodosUsuarios() {
        return this.repositorioDeUsuario.listarTodos();
    }
}
