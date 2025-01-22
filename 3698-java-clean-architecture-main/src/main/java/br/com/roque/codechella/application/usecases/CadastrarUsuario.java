package br.com.roque.codechella.application.usecases;

import br.com.roque.codechella.application.gateways.RepositorioDeUsuario;
import br.com.roque.codechella.domain.entities.usuario.Usuario;

public class CadastrarUsuario {

    private final RepositorioDeUsuario repositorioDeUsuario;

    public CadastrarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        this.repositorioDeUsuario = repositorioDeUsuario;
    }

    public Usuario cadastrarUsuario(Usuario usuario){
         return repositorioDeUsuario.cadastrarUsuario(usuario);
    }
}
